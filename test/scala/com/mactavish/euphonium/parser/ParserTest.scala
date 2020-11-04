package com.mactavish.euphonium.parser

import java.io.StringReader

import com.mactavish.euphonium.parser.Op._
import com.mactavish.euphonium.parser.SyntaxTree.Def._
import com.mactavish.euphonium.parser.SyntaxTree.Literal._
import com.mactavish.euphonium.parser.SyntaxTree._
import com.mactavish.euphonium.{Failure, Success, UnitTestSpec}

class ParserTest extends UnitTestSpec {
  implicit def str2TypeIdent(str: String): SyntaxTree.TypeIdent = TypeIdent(str)

  implicit def str2OrdinaryIdent(str: String): SyntaxTree.OrdinaryIdent = OrdinaryIdent(str)

  private val TString: TypeIdent = "String"
  private val TInt: TypeIdent = "Int"
  private val TBool: TypeIdent = "Bool"
  private val VFalse: OrdinaryIdent = "false"
  private val VTrue: OrdinaryIdent = "true"

  private val shouldPassSets = Map[String, List[ClassDef]](
    """
      |class Main
      |""".stripMargin -> List(ClassDef("Main")),
    """
      |class Main(b: String) {
      |   val a: Int = 5;
      |   val b: String = b;
      |   val c: Bool = false && true;
      |
      |   fun one: Int = 1;
      |   fun two(): Int = 2;
      |   fun isOne(v: Int): Bool = v == one();
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

  shouldPassSets foreach { case (input, expected) =>
    val res = Parser(new StringReader(input))
    res match {
      case Success(res) => res shouldEqual SyntaxTree.TopLevel(expected)
      case Failure(msg) => fail(msg)
    }
  }
}

//fun three: Int = {
//one() + two();
//};
