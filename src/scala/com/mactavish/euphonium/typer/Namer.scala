package com.mactavish.euphonium.typer

import com.mactavish.euphonium.Phase
import com.mactavish.euphonium.parser.{SyntaxTree => Syn}
import com.mactavish.euphonium.typer.{TypedTree => Typed}
import scala.collection.mutable

object Namer extends Phase[Syn.TopLevel, TypedTree.TopLevel] {
  type Typed = TypedTree.type

  def apply(topLevel: Syn.TopLevel): Option[Typed.TopLevel] = {
    // check if there's any duplicated class definition
    topLevel.classes.foldRight(Set[String]()) {
      (clazz, set) =>
        if (set.contains(clazz.name.literal))
          throw new Exception("duplicated class definition")
        else
          set + clazz.name.literal
    }

    // check if there's any class inheritance cycle
    val visited= mutable.Map[String, String]() // class's name -> root class's name
    def visit(clazz: Syn.Def.ClassDef, start: String):Unit = {
      val node = clazz.name.literal
      if (visited.contains(node) && visited(node) == start) {
        throw new Exception("class inheritance cycle")
      }
      visited(node) = start

      clazz.parent match {
        case Some(p) => visit(p,start)
        case None => ()
      }
    }
    topLevel.classes.foreach {
      clazz=>
        val node=clazz.name.literal
      if(!visited.contains(node)){
        visit(clazz,node)
      }
    }

    
    ???
  }


}
