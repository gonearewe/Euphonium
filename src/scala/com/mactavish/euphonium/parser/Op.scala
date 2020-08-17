package com.mactavish.euphonium.parser

sealed trait Op {
  val lit: String

  override def toString: String = lit
}

object Op {
  implicit def lit2UnaryOp(s: String): BinaryOp =
    Map("+" -> ADD(), "-" -> SUB(), "*" -> MUL(), "/" -> DIV(), "%" -> MOD(),
      "==" -> EQ(), "!=" -> NE(), "<" -> LT(), ">" -> GT(),
      "&&" -> AND(), "||" -> OR())(s)

  implicit def lit2BinaryOp(s:String):UnaryOp=
    Map("!" -> NOT(), "-" -> NEG())(s)

  sealed trait BinaryOp extends Op

  sealed trait UnaryOp extends Op

  case class ADD() extends BinaryOp {
    override val lit: String = "+"
  }

  case class SUB() extends BinaryOp {
    override val lit: String = "-"
  }

  case class MUL() extends BinaryOp {
    override val lit: String = "*"
  }

  case class DIV() extends BinaryOp {
    override val lit: String = "/"
  }

  case class MOD() extends BinaryOp {
    override val lit: String = "%"
  }

  case class EQ() extends BinaryOp {
    override val lit: String = "=="
  }

  case class NE() extends BinaryOp {
    override val lit: String = "!="
  }

  case class LT() extends BinaryOp {
    override val lit: String = "<"
  }

  case class GT() extends BinaryOp {
    override val lit: String = ">"
  }

  case class AND() extends BinaryOp {
    override val lit: String = "&&"
  }

  case class OR() extends BinaryOp {
    override val lit: String = "||"
  }

  case class NEG() extends UnaryOp {
    override val lit: String = "-"
  }

  case class NOT() extends UnaryOp {
    override val lit: String = "!"
  }

}
