package com.mactavish.euphonium.parser

import com.mactavish.euphonium.annot.Annot
import com.mactavish.euphonium.parser.Op._

trait Tree {
  type TopLevelAnnot <: Annot
  type ClassAnnot <: Annot
  type FieldAnnot <: Annot
  type MethodAnnot <: Annot
  type TypeLitAnnot <: Annot
  type LocalVarAnnot <: Annot
  type BlockAnnot <: Annot
  type ExprAnnot <: Annot

  sealed trait Node extends Product

  sealed trait Expr extends Node

  sealed trait Statement extends Expr

  sealed trait Def extends Statement

  case class TopLevel(classes: List[Def.ClassDef])(implicit annot: TopLevelAnnot) extends Node

  // definition(or declaration)

  object Def {

    case class MethodDef(name: OrdinaryIdent, params: List[LocalVarDef] = Nil, ret: TypeIdent, body: Expr)
                        (implicit annot: MethodAnnot) extends Def

    case class FieldDef(name: OrdinaryIdent, typ: TypeIdent, init: Option[Expr] = None)(implicit annot: FieldAnnot) extends Def

    case class LocalVarDef(name: OrdinaryIdent, typ: TypeIdent, init: Option[Expr] = None)(implicit annot: LocalVarAnnot) extends Def

    case class ClassDef(
                         name: TypeIdent,
                         consParams: List[LocalVarDef] = Nil,
                         parent: Option[ClassDef] = None,
                         fields: List[FieldDef] = Nil,
                         methods: List[MethodDef] = Nil
                       )(implicit annot: ClassAnnot) extends Def

  }

  // common expression

  case class Binary(op: BinaryOp, operands: (Expr, Expr))(implicit annot: ExprAnnot) extends Expr {
    override def toString: String = s"($op ${operands._1} ${operands._2})"
  }

  case class Unary(op: UnaryOp, operand: Expr)(implicit annot: ExprAnnot) extends Expr {
    override def toString: String = s"($op $operand)"
  }

  case class Block(expressions: List[Expr])(implicit annot: ExprAnnot) extends Expr

  case class If(condition: Expr, passExpr: Expr, elseExpr: Expr)(implicit annot: ExprAnnot) extends Expr

  case class FunCall(caller: Either[FunCall, OrdinaryIdent], args: List[Expr] = Nil)(implicit annot: ExprAnnot) extends Expr

  // Identifier

  sealed trait Identifier extends Tree

  case class TypeIdent(literal: String) extends Identifier

  case class OrdinaryIdent(literal: String) extends Identifier with Expr

  // Literal

  sealed trait Literal extends Tree

  object Literal {

    sealed trait ValueLiteral[T] extends Literal with Expr {
      val value: T

      override def toString: String = value.toString
    }

    sealed trait TypeLiteral extends Literal

    case class IntLit(value: Int) extends ValueLiteral[Int]

    case class BoolLit(value: Boolean) extends ValueLiteral[Boolean]

    case class StringLit(value: String) extends ValueLiteral[String]

    case class TInt() extends TypeLiteral

    case class TBool() extends TypeLiteral

    case class TString() extends TypeLiteral

    case class TUnit() extends TypeLiteral

    implicit def intLitWrapper(value: Int): IntLit = IntLit(value)

    implicit def boolLitWrapper(value: Boolean): BoolLit = BoolLit(value)

    implicit def stringLitWrapper(value: String): StringLit = StringLit(value)

  }

}
