package com.mactavish.euphonium.parser

sealed trait Op {
  val lit: String

  override def toString: String = lit
}

object Op {
  implicit def lit2BinaryOp(s: String): BinaryOp =
    Map("+" -> ADD, "-" -> SUB, "*" -> MUL, "/" -> DIV, "%" -> MOD,
      "==" -> EQ, "!=" -> NE, "<" -> LT,"<="->LE, ">" -> GT,">="->GE,
      "&&" -> AND, "||" -> OR)(s)

  implicit def lit2UnaryOp(s:String):UnaryOp=
    Map("!" -> NOT, "-" -> NEG)(s)

  sealed trait BinaryOp extends Op

  sealed trait UnaryOp extends Op

  object ADD extends BinaryOp {
    override val lit: String = "+"
  }

  object SUB extends BinaryOp {
    override val lit: String = "-"
  }

  object MUL extends BinaryOp {
    override val lit: String = "*"
  }

  object DIV extends BinaryOp {
    override val lit: String = "/"
  }

  object MOD extends BinaryOp {
    override val lit: String = "%"
  }

  object EQ extends BinaryOp {
    override val lit: String = "=="
  }

  object NE extends BinaryOp {
    override val lit: String = "!="
  }

  object LT extends BinaryOp {
    override val lit: String = "<"
  }

  object LE extends BinaryOp {
    override val lit: String = "<="
  }

  object GT extends BinaryOp {
    override val lit: String = ">"
  }

  object GE extends BinaryOp {
    override val lit: String = ">="
  }

  object AND extends BinaryOp {
    override val lit: String = "&&"
  }

  object OR extends BinaryOp {
    override val lit: String = "||"
  }

  object NEG extends UnaryOp {
    override val lit: String = "-"
  }

  object NOT extends UnaryOp {
    override val lit: String = "!"
  }

}
