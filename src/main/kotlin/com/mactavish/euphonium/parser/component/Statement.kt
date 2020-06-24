package com.mactavish.euphonium.parser.component

sealed class Statement {
    abstract fun type(env: Environment): Type
    abstract fun execute(env: Environment): Value
}

sealed class Declaration : Statement() {
    abstract val symbol: Symbol
    abstract val expr: Expr

    override fun execute(env: Environment): Value {
        env.define(symbol, expr)
        return UnitValue
    }

    override fun type(env: Environment): Type = UnitType
}

// VarDeclaration represents the declaration of ordinary variables and non-toplevel functions.
data class VarDeclaration(override val symbol: Symbol, override val expr: Expr) : Declaration()

// FuncDeclaration represents the declaration of toplevel functions.
data class FuncDeclaration(override val symbol: Symbol, override val expr: Expr, val env: Environment) : Declaration()

sealed class Expr : Statement() {
    override fun execute(env: Environment): Value = evalIn(env)

    abstract fun evalIn(env: Environment): Value
//    open fun type() :String =throw Exception("uninitialised expression type")
//    abstract val value:Value
//    open val children= mutableListOf<Expr>()
}

typealias Operator = String

/* Value */

sealed class Value : Expr()

data class IntValue(val i: Int = 0) : Value() {
    override fun type(env: Environment): Type = IntType
    override fun evalIn(env: Environment): Value = this
}

data class StringValue(val s: String = "") : Value() {
    override fun type(env: Environment): Type = StringType
    override fun evalIn(env: Environment): Value = this
}

data class BoolValue(val b: Boolean = false) : Value() {
    override fun type(env: Environment): Type = BoolType
    override fun evalIn(env: Environment): Value = this
}

object UnitValue : Value() {
    override fun type(env: Environment): Type = UnitType
    override fun evalIn(env: Environment): Value = this
}

// FuncValue represents an anonymous function literal.
data class FuncValue(
        val parameter: Map<Symbol, Type>,
        val retType: Type,
        val body: Expr,
        val env: Environment
) : Value() {
    override fun type(env: Environment): Type = FuncType(parameter.map { it.value }, retType)

    override fun evalIn(env: Environment): Value = this
}

///////

//data class LiteralExpr(override val value: Value):Expr()

data class VariableExpr(val symbol: Symbol) : Expr() {
    override fun type(env: Environment): Type =
            env.resolve(symbol)?.type(env) ?: throw Exception("resolve symbol: $symbol in environment: $env")

    override fun evalIn(env: Environment): Value = env.resolve(symbol)?.evalIn(env) ?: throw Exception()
}

data class UnaryExpr(val op: Operator, val operand: Expr) : Expr() {
    override fun evalIn(env: Environment): Value {
        val operandValue = operand.evalIn(env)
        return when (op) {
            "+" -> operandValue
            "-" -> IntValue(-(operandValue as IntValue).i)
            "!" -> BoolValue(!(operandValue as BoolValue).b)
            else -> throw Exception("unresolved unary expression")
        }
    }

    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }
}

data class BinaryExpr(val op: Operator, val firstOperand: Expr, val secondOperand: Expr) : Expr() {
    override fun evalIn(env: Environment): Value {
        val (first, second) = Pair(firstOperand.evalIn(env), secondOperand.evalIn(env))
        return when (op) {
            "==" -> BoolValue(first == second)
            "!=" -> BoolValue(first != second)
            "&&" -> BoolValue((first as BoolValue).b && (second as BoolValue).b)
            "||" -> BoolValue((first as BoolValue).b || (second as BoolValue).b)
            else -> {
                val a = (first as IntValue).i
                val b = (second as IntValue).i
                when (op) {
                    ">=" -> BoolValue(a >= b)
                    ">" -> BoolValue(a > b)
                    "<=" -> BoolValue(a < b)
                    "<" -> BoolValue(a < b)
                    "+" -> IntValue(a + b)
                    "-" -> IntValue(a - b)
                    "*" -> IntValue(a * b)
                    "/" -> IntValue(a / b)
                    "%" -> IntValue(a % b)
                    else -> throw Exception("unresolved binary expression")
                }
            }
        }
    }

    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }
}

data class BlockExpr(val statements: List<Statement> = mutableListOf()) : Expr() {
    override fun type(env: Environment): Type = (statements.last() as Expr).type(env)

    override fun evalIn(env: Environment): Value {
        (0 until statements.size - 1).forEach { statements[it].execute(env) }
        return (statements.last() as Expr).evalIn(env)
    }
}

// if ( condition ) passExpr else elseExpr
data class IfExpr(val condition: Expr, val passExpr: Expr, val elseExpr: Expr) : Expr() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(env: Environment): Value {
        TODO("Not yet implemented")
    }
}

data class FuncCallExpr(val func: Expr, val arguments: List<Expr>) : Expr() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(env: Environment): Value {
        val f = func.evalIn(env) as FuncValue
        val parameterNames = f.parameter.map { it.key }

        // put arguments into this function's environment
        parameterNames.zip(arguments.map { it.evalIn(env) }
                // NOTE: instead of just arguments, so Euphonium applies eager eval
        ).forEach { f.env.define(it.first, it.second) }

        return f.body.evalIn(f.env) // eval in its own environment(the captured one from which the function is defined)
    }
}
