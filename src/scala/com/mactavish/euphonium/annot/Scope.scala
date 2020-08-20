package com.mactavish.euphonium.annot

import com.mactavish.euphonium.annot.Symbol._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

sealed trait Scope extends Annot {
  type Item<:Symbol
  protected var symbols:mutable.Map[String,Item]=new mutable.TreeMap()

  def contains(key:String):Boolean = symbols.contains(key)

  def define(symbol: Item):Unit={
    symbols(symbol.name)=symbol
    symbol.domain=this
  }
}

object Scope {

  class GlobalScope extends Scope {
    override type Item = ClassSymbol
  }

  class ClassScope(val parent: Option[ClassScope]) extends Scope {
    override type Item = MemberSymbol

    var owner: ClassSymbol = _
  }

  class FormalScope extends Scope {
    override type Item = LocalVarSymbol

    var owner: MethodSymbol = _
  }

  class LocalScope extends Scope {
    override type Item = LocalVarSymbol


  }

  class ScopeContext(private val scopes:List[Scope],val clazz:ClassSymbol){
    val currentScope:Scope =scopes.head

    def globalScope:GlobalScope = scopes.last.asInstanceOf

    def newScope[S<:Scope]:ScopeContext= new ScopeContext(new S ::scopes,clazz)

    def define(symbol: Symbol): Unit = currentScope.define(symbol.asInstanceOf[currentScope.Item])
  }

}
