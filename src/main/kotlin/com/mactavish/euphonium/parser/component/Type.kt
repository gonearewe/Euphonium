package com.mactavish.euphonium.parser.component

sealed class Type {
    companion object {
        fun of(s: String) = when (s) {
            "Int" -> IntType
            "Bool" -> BoolType
            "String" -> StringType
            "Unit" -> UnitType
            else -> throw Exception("unknown return type $s")
        }
    }
}

object UninferredType : Type()

object IntType : Type()
object StringType : Type()
object BoolType : Type()
object UnitType : Type()
data class FuncType(val paramTypes: List<Type>, val retType: Type) : Type()
data class UnionType(val constituents: List<Type>) : Type()

