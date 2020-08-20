package com.mactavish.euphonium.typer

import com.mactavish.euphonium.Phase
import com.mactavish.euphonium.parser.SyntaxTree

import scala.collection.mutable

object Namer extends Phase[SyntaxTree.TopLevel ,TypedTree.TopLevel ]{
  def apply(topLevel: SyntaxTree.TopLevel): Option[TypedTree.TopLevel] = {
//    topLevel.classes.foldRight(new mutable.Map)
    ???
  }
}
