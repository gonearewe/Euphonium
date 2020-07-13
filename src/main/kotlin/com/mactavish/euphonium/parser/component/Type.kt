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

data class FuncType(val paramTypes: List<Type>, val retType: Type) : Type() {
    override fun toString(): String {
        return paramTypes.joinToString(separator = ",", prefix = "(", postfix = ")=>") + retType
    }
}

/**
 * Looks like:
 *      let a:(Bool,Int) = (true,10);
 * Notice that [TupleType] doesn't owns a name to be identified from others.
 */
data class TupleType(val constituents: List<Type>) : Type() {
    override fun toString(): String {
        // Bool*Int
        return constituents.joinToString(separator = "*")
    }
}

/**
 * Looks like:
 *      struct Student = {
 *            name: String
 *            age:  Int
 *      }
 */
data class StructType(val name: Symbol, val fields: Map<Symbol, Type>) {
    override fun toString(): String {
        // Student{name:String, age:Int}
        return fields.map { it.key + ":" + it.key }.joinToString(separator = ", ", prefix = "$name{", postfix = "}")
    }
}

/**
 * Looks like:
 *      data Result =
 *               | Success Int
 *               | Failure String*Int
 */
data class TaggedUnionType(val name: Symbol, val constituents: Map<Symbol, TupleType>) : Type() {
    override fun toString(): String {
        // Result(Success Int | Failure String*Int)
        return constituents.map { it.key + " " + it.value }.joinToString(prefix = "$name(", separator = " | ", postfix = ")")
    }
}


class TypeRegistry() : HashMap<Regex, Type>() {
    init {
        listOf("Int" to IntType, "Bool" to BoolType, "String" to StringType, "Unit" to UnitType)
                .forEach { put(Regex(it.first), it.second) }
    }


}
