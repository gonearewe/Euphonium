package com.mactavish.euphonium.annot

import com.mactavish.euphonium.parser.Def._
import com.mactavish.euphonium.annot.Type._

sealed trait Symbol extends Annot {
  type Typ <: Type

  def name: String

  var domain: Scope =_
}

object Symbol {

  object AnySymbol extends Symbol {
    override type Typ = AnyType.type

    override def name: String = "Any"


  }

  class ClassSymbol(tree: ClassDef, val parent: Either[AnySymbol.type, ClassSymbol]) extends Symbol {
    override type Typ = ClassType

    override def name: String = tree.name.literal


  }

  sealed trait MemberSymbol extends Symbol

  class FieldSymbol(tree: FieldDef, val owner: ClassSymbol, val typ: Type) extends MemberSymbol {
    override type Typ = Type

    override def name: String = tree.name.literal


  }

  class MethodSymbol(tree: MethodDef, val owner: ClassSymbol, val typ: FunType) extends MemberSymbol {
    override type Typ = FunType

    override def name: String = ???


  }

  class LocalVarSymbol(tree: LocalVarDef, val typ: Type) extends Symbol {
    override type Typ = Type

    override def name: String = ???


  }
}
