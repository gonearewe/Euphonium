package com.mactavish.euphonium.parser

sealed trait TreeNode

sealed trait Expr extends TreeNode
sealed trait Statement extends Expr
sealed trait Def extends Statement

case class MethodDef(name:OrdinaryIdent, params:List[LocalVarDef], ret:TypeLiteral, body:Expr) extends Def
case class FieldDef(name:OrdinaryIdent, typ:TypeLiteral, init:Option[Expr]) extends Def
case class LocalVarDef(name:OrdinaryIdent, typ:TypeLiteral, init:Option[Expr]) extends Def
case class ClassDef(name: TypeIdent,fields:FieldDef,methods:MethodDef) extends Def

sealed trait Identifier extends TreeNode
case class TypeIdent(literal:String) extends Identifier
case class OrdinaryIdent(literal:String) extends Identifier with Expr

case class Binary(op:BinaryOp, operands:(Expr,Expr)) extends Expr
case class Unary(op:UnaryOp,operand:Expr) extends Expr
case class Block(expressions:List[Expr]) extends Expr
case class If(condition:Expr,passExpr:Expr,elseExpr:Expr) extends Expr

sealed trait Literal
sealed trait ValueLiteral[T] extends Literal with Expr{
  val value:T
}
sealed trait TypeLiteral extends Literal

case class IntLit(value:Int) extends ValueLiteral[Int]
case class BoolLit(value:Boolean) extends ValueLiteral[Boolean]
case class StringLit(value: String) extends ValueLiteral[String]

case class TInt() extends TypeLiteral
case class TBool() extends TypeLiteral
case class TString() extends TypeLiteral
case class TUnit() extends TypeLiteral

sealed trait Op
sealed trait BinaryOp extends Op
sealed trait UnaryOp extends Op

case class ADD() extends BinaryOp
case class SUB() extends BinaryOp
case class MUL() extends BinaryOp
case class DIV() extends BinaryOp
case class EQ() extends BinaryOp
case class NE() extends BinaryOp
case class LT() extends BinaryOp
case class GT() extends BinaryOp
case class AND() extends BinaryOp
case class OR() extends BinaryOp

case class NEG() extends UnaryOp
case class NOT() extends UnaryOp
