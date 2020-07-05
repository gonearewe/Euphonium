package com.mactavish.euphonium.parser.component

sealed class Statement {
    open val env: Environment = Environment.newUndefinedEnvironment()
    abstract fun type(): Type
    abstract fun execute(): Value
}

sealed class Declaration : Statement() {
    abstract val symbol: Symbol
    abstract val expr: Expr

    override fun execute(): Value {
        env.define(symbol, expr)
        return UnitValue
    }

    override fun type(): Type = UnitType
}

// VarDeclaration represents the declaration of ordinary variables and non-toplevel functions.
data class VarDeclaration(override val symbol: Symbol, override val expr: Expr, override val env: Environment) : Declaration()

// FuncDeclaration represents the declaration of toplevel functions.
data class FuncDeclaration(override val symbol: Symbol, override val expr: Expr, override val env: Environment) : Declaration()

sealed class Expr : Statement() {
    override fun execute(): Value = evalIn()

    abstract fun evalIn(): Value
//    open fun type() :String =throw Exception("uninitialised expression type")
//    abstract val value:Value
//    open val children= mutableListOf<Expr>()
}

typealias Operator = String

/* Value */

sealed class Value : Expr()

data class IntValue(val i: Int = 0) : Value() {
    override fun type(): Type = IntType
    override fun evalIn(): Value = this
}

data class StringValue(val s: String = "") : Value() {
    override fun type(): Type = StringType
    override fun evalIn(): Value = this
}

data class BoolValue(val b: Boolean = false) : Value() {
    override fun type(): Type = BoolType
    override fun evalIn(): Value = this
}

object UnitValue : Value() {
    override fun type(): Type = UnitType
    override fun evalIn(): Value = this
}

// FuncValue represents an anonymous function literal.
data class FuncValue(
        val parameter: Map<Symbol, Type>,
        val retType: Type,
        val body: Expr,
        override val env: Environment
) : Value() {
    override fun type(): Type = FuncType(parameter.map { it.value }, retType)

    override fun evalIn(): Value = this
}

///////

//data class LiteralExpr(override val value: Value):Expr()

data class VariableExpr(val symbol: Symbol, override val env: Environment) : Expr() {
    override fun type(): Type =
            env.resolve(symbol)?.type() ?: throw Exception("resolve symbol: $symbol in environment: $env")

    override fun evalIn(): Value = env.resolve(symbol)?.evalIn()
            ?: throw Exception("resolving \"$symbol\" in environment $env")
}

data class UnaryExpr(val op: Operator, val operand: Expr) : Expr() {
    override fun evalIn(): Value {
        val operandValue = operand.evalIn()
        return when (op) {
            "+" -> operandValue
            "-" -> IntValue(-(operandValue as IntValue).i)
            "!" -> BoolValue(!(operandValue as BoolValue).b)
            else -> throw Exception("unresolved unary expression")
        }
    }

    override fun type(): Type {
        TODO("Not yet implemented")
    }
}

data class BinaryExpr(val op: Operator, val firstOperand: Expr, val secondOperand: Expr) : Expr() {
    override fun evalIn(): Value {
        val (first, second) = Pair(firstOperand.evalIn(), secondOperand.evalIn())
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

    override fun type(): Type {
        TODO("Not yet implemented")
    }
}

data class BlockExpr(val statements: List<Statement> = mutableListOf()) : Expr() {
    override fun type(): Type = (statements.last() as Expr).type()

    override fun evalIn(): Value {
        (0 until statements.size - 1).forEach { statements[it].execute() }
        return (statements.last() as Expr).evalIn()
    }
}

// if ( condition ) passExpr else elseExpr
data class IfExpr(val condition: Expr, val passExpr: Expr, val elseExpr: Expr) : Expr() {
    override fun type(): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(): Value {
        TODO("Not yet implemented")
    }
}

data class FuncCallExpr(val func: Expr, val arguments: List<Expr>) : Expr() {
    override fun type(): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(): Value {
        val f = func.evalIn() as FuncValue
        val parameterNames = f.parameter.map { it.key }

        // put arguments into this function's environment
        parameterNames.zip(arguments.map { it.evalIn() }
                // NOTE: instead of just arguments, so Euphonium applies eager eval
        ).forEach { f.env.define(it.first, it.second) }

        return f.body.evalIn() // eval in its own environment(the captured one from which the function is defined)
    }
}
