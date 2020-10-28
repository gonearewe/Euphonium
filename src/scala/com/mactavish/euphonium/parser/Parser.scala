package com.mactavish.euphonium.parser

import com.codecommit.gll._
import com.mactavish.euphonium.Phase
import com.mactavish.euphonium.{Result => Res, Success => Ok, Failure => Fail}
import com.mactavish.euphonium.annot.Type.AnyType
import com.mactavish.euphonium.parser.SyntaxTree._
import com.mactavish.euphonium.parser.SyntaxTree.Def._
import com.mactavish.euphonium.parser.SyntaxTree.Literal._
import com.mactavish.euphonium.parser.Op._
import java.io.{InputStream, Reader}

import scala.annotation.tailrec
import scala.collection.mutable
import java.lang.{String => FailMsg}

object Parser extends RegexParsers with Phase[Reader, SyntaxTree.TopLevel, FailMsg] {
  override def apply(input: Reader): Res[SyntaxTree.TopLevel, FailMsg] = {
    // parse `ClassDef` for constructing `TopLevel`
    val parseResult = classDef(LineStream(input)).toList map {
      case Success(value, _) => value
      case Failure(reason, _) => reason match {
        case _ => ???
        // fault handle
        //case ExpectedLiteral(expect, received) =>
        //case ExpectedRegex(regex) =>
        //case UnexpectedEndOfStream(expected) =>
        //case UnexpectedTrailingChars(received) =>
        //case UnexpectedChars(received) =>
        //case SyntaxError =>
      }
    }
    val parsedClasses = parseResult.map { case (classDef, _) => classDef }
    // check if there's any duplicated class definition
    val classNames: List[TypeIdent] = parsedClasses.map {
      _.name
    }
    if (classNames.size != classNames.distinct.size) return Fail("duplicated class definition")

    // check if there's any undefined class appearing in inheritance
    val classNameSet: Set[TypeIdent] = classNames.toSet
    parseResult.filter {
      _._2.isDefined
    }.flatMap { case (_, Some(parent)) =>
      if (classNameSet(parent)) None
      else Some(parent.literal)
    } match {
      case x if x != Nil => return Fail(s"undefined class(es) ${x.mkString(", ")}")
    }

    // check if there's any class inheritance cycle
    val inheritanceMap = parseResult.flatMap {
      case (classDef, None) => None
      case (ClassDef(name, _, _, _, _), Some(parent)) => Some(name -> parent)
    }.toMap // inheritanceMap is a map from class(name) to its parent(name), class that has no superclass isn't included
    inheritanceMap.flatMap { case (start, _) =>
      @tailrec
      def foundCycle(c: TypeIdent): Boolean = {
        if (!inheritanceMap.contains(c)) false
        else if (inheritanceMap(c) == start) true
        else foundCycle(inheritanceMap(c))
      }

      Some(start).filter(foundCycle)
    } match {
      case x if x != Nil => return Fail(s"class inheritance cycle found, including ${x.mkString(", ")}")
    }

    // complete all `ClassDef`
    val nameClassMap = parsedClasses.map { c => c.name -> c }.toMap // a map from each class's name to itself
    val completedNameClassMap = mutable.HashMap[TypeIdent, ClassDef]()

    def completeClassDef(c: ClassDef): Unit = {
      val name = c.name
      // I don't have a superclass, so I'm already completed (my parent is truly `None`)
      if (!inheritanceMap.contains(name)) {
        completedNameClassMap(name) = c
        return
      }
      // I need my superclass completed(shown in `completedNameClassMap`) before I do
      val parent = inheritanceMap(name)
      if (!completedNameClassMap.contains(parent)) completeClassDef(nameClassMap(parent))
      // complete myself with field `parent` filled
      completedNameClassMap(name) = nameClassMap(name).copy(parent = Some(completedNameClassMap(parent)))
    }

    nameClassMap.values.foreach(completeClassDef)

    Ok(TopLevel(classes = completedNameClassMap.values.toList))
  }

  private lazy val expr: Parser[Expr] = funCall | expr6

  /**
   * Parse class definitions, output a pair of `ClassDef` and its parent's TypeIdent (if any),
   * since we can't parse `ClassDef` recursively.
   * We can complete the `ClassDef` later manually.
   */
  private lazy val classDef: Parser[(ClassDef, Option[TypeIdent])] =
    ("class" ~> typeIdent) ~ opt("(" ~> paramList <~ ")") ~ opt("extends" ~> typeIdent) ~
      opt("{" ~> rep(methodDef | fieldDef) <~ "}") ^^ {
      (id, consParams, parent, body) =>
        ClassDef(
          name = id,
          consParams = consParams.getOrElse(Nil),
          // use `collect` to filter value of specific type without casting it afterwards
          fields = body.getOrElse(Nil).collect { case x: FieldDef => x },
          methods = body.getOrElse(Nil).collect { case x: MethodDef => x }
        ) -> parent
    }

  // expression level parsers

  private lazy val ifExpr: Parser[If] =
    (("if" ~ "(") ~> expr) ~ (")" ~> expr) ~ ("else" ~> expr <~ ";") ^^ {
      (cond, passExpr, elseExpr) => If(cond, passExpr, elseExpr)
    }

  private lazy val block: Parser[Block] =
    "{" ~> ((expr | localVarDef) + ";") <~ ";".? <~ "}" ^^ {
      Block(_)
    }

  private lazy val expr0: Parser[Expr] = ifExpr | block | boolLit | stringLit | intLit | ordinaryIdent | "(" ~> expr <~ ")"

  private lazy val expr1: Parser[Expr] = (
    "!" ~ expr1 ^^ { (op, e) => Unary(op, e) }
      | expr0
    )

  private lazy val expr2: Parser[Expr] = (
    expr2 ~ ("*" | "/" | "%") ~ expr2 ^^ binary
      | expr1
    )

  private lazy val expr3: Parser[Expr] = (
    expr3 ~ ("+" | "-") ~ expr3 ^^ binary
      | expr2
    )

  private lazy val expr4: Parser[Expr] = (
    expr4 ~ (">=" | ">" | "<=" | "<") ~ expr4 ^^ binary
      | expr3
    )

  private lazy val expr5: Parser[Expr] = (
    expr5 ~ "&&" ~ expr5 ^^ binary
      | expr4
    )

  private lazy val expr6: Parser[Expr] = (
    expr6 ~ "||" ~ expr6 ^^ binary
      | expr5
    )

  private lazy val funCall: Parser[FunCall] =
    (ordinaryIdent | funCall) ~ ("(" ~> opt(expr6 + ",") <~ ")") ^^ {
      (caller, args) =>
        caller match {
          case c: FunCall => FunCall(Left(c), args.getOrElse(Nil))
          case c: OrdinaryIdent => FunCall(Right(c), args.getOrElse(Nil))
        }
    }

  private def binary(a: Expr, op: String, b: Expr) = Binary(op, (a, b))

  // class level parsers

  private lazy val paramList: Parser[List[LocalVarDef]] =
    varWithType + "," ^^ {
      _ map { case (id, typ) => LocalVarDef(id, typ) }
    }

  private lazy val varWithType: Parser[(OrdinaryIdent, TypeIdent)] =
    ordinaryIdent ~ (":" ~> typeIdent) ^^ {
      (_, _)
    }

  private lazy val fieldDef: Parser[FieldDef] =
    ("val" ~> ordinaryIdent) ~ (":" ~> typeIdent) ~ opt("=" ~> expr) ^^ {
      (id, typ, init) => FieldDef(id, typ, init)
    }

  private lazy val methodDef: Parser[MethodDef] =
    ("fun" ~> ordinaryIdent) ~ opt("(" ~> paramList <~ ")") ~ (":" ~> typeIdent) ~ ("=" ~> expr <~ ";") ^^ {
      (name, params, retType, body) => MethodDef(name, params.getOrElse(List()), retType, body)
    }

  private lazy val localVarDef: Parser[LocalVarDef] =
    ("val" ~> ordinaryIdent) ~ (":" ~> typeIdent) ~ opt("=" ~> expr) ^^ {
      (id, typ, init) => LocalVarDef(id, typ, init)
    }


  private lazy val intLit: Parser[IntLit] = """^\d+""".r ^^ { num => IntLit(num.toInt) }

  private lazy val boolLit: Parser[BoolLit] = (
    "true" ^^ { _ => BoolLit(true) }
      | "false" ^^ { _ => BoolLit(false) }
    )

  private lazy val stringLit: Parser[StringLit] = """".*"""".r ^^ { s => StringLit(s.substring(1, s.length - 1)) }

  private lazy val typeIdent: Parser[TypeIdent] = """^[A-Z]\w*""".r ^^ { c => TypeIdent(c) }

  private lazy val ordinaryIdent: Parser[OrdinaryIdent] = """\w+""".r ^^ { c => OrdinaryIdent(c) }

}
