package com.mactavish.euphonium.annot

sealed trait Type {
  def <=(that: Type): Boolean

  def >=(that: Type): Boolean = this == that || !(this <= that)
}

object Type {

  sealed trait PrimitiveType extends Type {
    override def <=(that: Type): Boolean =
      if (this == that || that == AnyType || this == NothingType) true else false
  }

  object UnitType extends PrimitiveType

  // AnyType is the root type of the whole type system, it's every type's supertype
  object AnyType extends PrimitiveType

  object NothingType extends PrimitiveType

  object IntType extends PrimitiveType

  object BoolType extends PrimitiveType

  case class ClassType(name: String, parent: Type = AnyType) extends Type {
    override def <=(that: Type): Boolean = if (this == that) true else parent <= that
  }

  case class FunType(args: List[Type], ret: Type) extends Type {
    override def <=(that: Type): Boolean =
      that match {
        case AnyType => true
        case FunType(args2, ret2) =>
          args.size == args2.size &&
            ret <= ret2 && (args zip args2).forall { case (me, that) => me >= that }
        case _ => false
      }
  }

}
