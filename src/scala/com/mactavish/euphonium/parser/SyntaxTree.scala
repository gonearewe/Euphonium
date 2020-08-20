package com.mactavish.euphonium.parser

import com.mactavish.euphonium.annot.Annot

object SyntaxTree extends Tree {
  implicit object NoType extends Annot

  type TopLevelAnnot = NoType.type
  type ClassAnnot = NoType.type
  type FieldAnnot = NoType.type
  type MethodAnnot = NoType.type
  type TypeLitAnnot = NoType.type
  type LocalVarAnnot = NoType.type
  type BlockAnnot = NoType.type
  type ExprAnnot = NoType.type
}
