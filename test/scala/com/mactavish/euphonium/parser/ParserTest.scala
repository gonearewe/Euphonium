package com.mactavish.euphonium.parser

import java.io.{Reader, StringReader}

import com.mactavish.euphonium.UnitTestSpec
import com.mactavish.euphonium.parser.SyntaxTree.Def._
import com.mactavish.euphonium.parser.SyntaxTree._
import com.mactavish.euphonium.parser.SyntaxTree.Literal._
import com.mactavish.euphonium.parser.Op._

class ParserTest extends UnitTestSpec {
  implicit def str2TypeIdent(str: String): SyntaxTree.TypeIdent = TypeIdent(str)

  implicit def str2OrdinaryIdent(str: String): SyntaxTree.OrdinaryIdent = OrdinaryIdent(str)

  val TString: TypeIdent = "String"
  val TInt: TypeIdent = "Int"
  val TBool: TypeIdent = "Bool"
  val VFalse: OrdinaryIdent = "false"
  val VTrue: OrdinaryIdent = "true"

  val shouldPassSets = Map[String, List[ClassDef]](
    """
      |class Main
      |""".stripMargin -> List(ClassDef("Main")),
    """
      |class Main(b: String) {
      |   val a: Int = 5
      |   val b: String = b
      |   val c: Bool = false && true
      |
      |   fun one: Int = 1
      |   fun two(): Int = 2
      |   fun three: Int = {
      |       one() + two()
      |   }
      |   fun isOne(v: Int): Bool = v == one()
      |}""".stripMargin ->
      List(ClassDef(
        name = TypeIdent("Main"),
        consParams = LocalVarDef("b", TString, init = None) :: Nil,
        fields =
          FieldDef("a", TInt, init = Some(5)) ::
            FieldDef("b", TString, init = Some(StringLit("b"))) ::
            FieldDef("c", TBool, init = Some(Binary(AND, VFalse -> VTrue))) :: Nil,
        methods =
          MethodDef("one", ret = TInt, body = 1) ::
            MethodDef("two", ret = TInt, body = 2) ::
            MethodDef(
              "three",
              ret = TInt,
              body = Block(
                Binary(
                  ADD,
                  FunCall(Right("one")) -> FunCall(Right("two"))
                ) :: Nil)) ::
            MethodDef(
              "isOne",
              params = LocalVarDef("v", TInt) :: Nil,
              ret = TBool,
              body = Binary(EQ, OrdinaryIdent("v") -> FunCall(Right("one")))
            ) :: Nil
      ))
  )

  shouldPassSets foreach { case (input,expected) =>
    Parser(new StringReader(input)) shouldEqual SyntaxTree.TopLevel(expected)
  }
}
