package com.mactavish.euphonium.parser

sealed abstract class TreeNode

case class MethodDef(name:OrdinaryIdent, params:List[VarDef], ret:TypeLiteral, body:Block)

case class VarDef(name:OrdinaryIdent, typ:TypeLiteral, init:Option[Expr])

case class ClassDef(name: TypeIdent,)

sealed abstract class Identifier(literal:String)

case class TypeIdent(literal:String) extends Identifier(literal)

case class OrdinaryIdent(literal:String) extends Identifier(literal)

sealed trait Expr
trait Statement extends Expr

case class Binary(op:BinaryOp, operands:(Expr,Expr)) extends Expr
case class Block(expressions:List[Expr]) extends Expr


sealed trait Literal
trait ValueLiteral[T] extends Literal with Expr{
  val value:T
}
trait TypeLiteral extends Literal

case class IntLit(value:Int) extends ValueLiteral[Int]
case class BoolLit(value:Boolean) extends ValueLiteral[Boolean]

case class TInt() extends TypeLiteral
case class TBool() extends TypeLiteral
case class TString() extends TypeLiteral
case class TUnit() extends TypeLiteral

sealed trait Op
trait BinaryOp extends Op
trait UnaryOp extends Op

case class ADD() extends BinaryOp
case class SUB() extends BinaryOp
case class MUL() extends BinaryOp
case class DIV() extends BinaryOp
