package com.mactavish.euphonium.parser

import com.codecommit.gll.{LineStream, RegexParsers}
import com.mactavish.euphonium.parser.Identifier.{OrdinaryIdent, TypeIdent}
import com.mactavish.euphonium.parser.Literal.IntLit
import com.mactavish.euphonium.parser.Op._


class EuphoniumParser extends RegexParsers {
  lazy val expr: Parser[Expr] = expr6

  lazy val ifExpr: Parser[If] =
    (("if" ~ "(") ~> expr) ~ (")" ~> expr) ~ ("else" ~> expr) ^^ {
      (cond, passExpr, elseExpr) => If(cond, passExpr, elseExpr)
    }

  lazy val expr0: Parser[Expr] = intLit | ordinaryIdent | "(" ~> expr <~ ")"

  lazy val expr1: Parser[Expr] = (
    "!" ~ expr1 ^^ {(op,e) => Unary(op, e) }
      | expr0
    )

  lazy val expr2: Parser[Expr] = (
    expr2 ~ ("*"|"/"|"%") ~ expr2 ^^ { (a, op, b) => Binary(op, (a, b)) }
      | expr1
    )

  lazy val expr3: Parser[Expr] = (
    expr3 ~ ("+" | "-") ~ expr3 ^^ { (a, op, b) => Binary(op, (a, b)) }
      | expr2
    )

  lazy val expr4: Parser[Expr] = expr3

  lazy val expr5: Parser[Expr] = (
    expr5 ~ "&&" ~ expr5 ^^ { (a, _, b) => Binary(AND(), (a, b)) }
      | expr4
    )

  lazy val expr6: Parser[Expr] = (
    expr6 ~ "||" ~ expr6 ^^ { (a, _, b) => Binary(OR(), (a, b)) }
      | expr5
    )


  lazy val intLit: Parser[IntLit] = """^\d+""".r ^^ { num => IntLit(num.toInt) }

  lazy val typeIdent: Parser[TypeIdent] = """^[A-Z]\w*""".r ^^ { c => TypeIdent(c) }

  lazy val ordinaryIdent: Parser[OrdinaryIdent] = """\w+""".r ^^ { c => OrdinaryIdent(c) }

}

object EuphoniumParser {
  def main(args: Array[String]): Unit = {

    val p = new EuphoniumParser

    println(p.expr(LineStream("2+1/2*6-9+70*2")))
    println(p.expr(LineStream("2-1+2-6-9+70+2")))
  }
}
