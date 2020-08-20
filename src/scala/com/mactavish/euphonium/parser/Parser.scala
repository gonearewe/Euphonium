package com.mactavish.euphonium.parser

import com.codecommit.gll._
import com.mactavish.euphonium.Phase
import com.mactavish.euphonium.parser.SyntaxTree._
import com.mactavish.euphonium.parser.SyntaxTree.Def._
import com.mactavish.euphonium.parser.SyntaxTree.Literal._
import com.mactavish.euphonium.parser.Op._

import java.io.InputStream


class Parser extends RegexParsers with Phase[InputStream,]{
  lazy val expr: Parser[Expr] = expr6
  lazy val classDef: Parser[Expr] =
    ("class" ~> typeIdent) ~ opt("(" ~> paramList <~ ")") ~ ("{" ~> rep(methodDef | fieldDef) <~ "}") ^^ {
      (id, consParams, body) =>
        ClassDef(id, consParams.getOrElse(List()),
          for (e@FieldDef(_, _, _) <- body) yield e,
          for (e@MethodDef(_, _, _, _) <- body) yield e)
    }


  // expression level parsers

  private lazy val ifExpr: Parser[If] =
    (("if" ~ "(") ~> expr) ~ (")" ~> expr) ~ ("else" ~> expr <~ ";") ^^ {
      (cond, passExpr, elseExpr) => If(cond, passExpr, elseExpr)
    }

  private lazy val block: Parser[Block] =
    "{" ~> ((expr|localVarDef) + ";") <~ ";".? <~ "}" ^^ {
      Block
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

object Parser {
  def main(args: Array[String]): Unit = {
    val p = new Parser
    val s = LineStream(
      """
        |fun main(arg:String):Int ={
        | if(2-1+3>8*7){
        |     val x:Int = 87;
        |     {
        |       x
        |     }
        | }else{
        |     66
        | };
        |};
        |""".stripMargin)

    println(p.methodDef(s))
  }
}
