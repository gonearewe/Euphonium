//package com.mactavish.euphonium.typer
//
//import com.mactavish.euphonium.{Phase, Result}
//import com.mactavish.euphonium.parser.{SyntaxTree => Syn}
//import com.mactavish.euphonium.typer.{TypedTree => Typed}
//
//import scala.collection.mutable
//import java.lang.{String => FailMsg}
//
//object Namer extends Phase[Syn.TopLevel, TypedTree.TopLevel,FailMsg] {
//  type Typed = TypedTree.type
//
//  def apply(topLevel: Syn.TopLevel): Result[Typed.TopLevel,FailMsg] = {
//    // check if there's any duplicated class definition
//    topLevel.classes.foldRight(Set[String]()) {
//      (clazz, set) =>
//        if (set.contains(clazz.name.literal))
//          throw new Exception("duplicated class definition")
//        else
//          set + clazz.name.literal
//    }
//
//    // check if there's any class inheritance cycle
//    val visited= mutable.Map[String, String]() // class's name -> root class's name
//    def visit(clazz: Syn.Def.ClassDef, start: String):Unit = {
//      val node = clazz.name.literal
//      if (visited.contains(node) && visited(node) == start) {
//        throw new Exception("class inheritance cycle")
//      }
//      visited(node) = start
//
//      clazz.parent match {
//        case Some(p) => visit(p,start)
//        case None => ()
//      }
//    }
//    topLevel.classes.foreach {
//      clazz=>
//        val node=clazz.name.literal
//      if(!visited.contains(node)){
//        visit(clazz,node)
//      }
//    }
//
//
//    ???
//  }
//
//
//}
