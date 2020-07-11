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
    override fun execute(): Value = eval()

    abstract fun eval(): Value
//    open fun type() :String =throw Exception("uninitialised expression type")
//    abstract val value:Value
//    open val children= mutableListOf<Expr>()
}

typealias Operator = String

/* Value */

sealed class Value : Expr()

data class IntValue(val i: Int = 0) : Value() {
    override fun type(): Type = IntType
    override fun eval(): Value = this
}

data class StringValue(val s: String = "") : Value() {
    override fun type(): Type = StringType
    override fun eval(): Value = this
}

data class BoolValue(val b: Boolean = false) : Value() {
    override fun type(): Type = BoolType
    override fun eval(): Value = this
}

object UnitValue : Value() {
    override fun type(): Type = UnitType
    override fun eval(): Value = this
    override fun toString(): String = "UnitValue"
}

// FuncValue represents an anonymous function literal.
data class FuncValue(
        val parameter: Map<Symbol, Type>,
        val retType: Type,
        val body: Expr,
        override val env: Environment // its own environment for executing function
) : Value() {
    override fun type(): Type = FuncType(parameter.map { it.value }, retType)

    override fun eval(): Value = this
}

///////

data class NativeExpr(val block: (Environment) -> Value, override val env: Environment) : Expr() {
    override fun type(): Type {
        TODO("Not yet implemented")
    }

    override fun eval(): Value = block(env)
}

data class VariableExpr(val symbol: Symbol, override val env: Environment) : Expr() {
    override fun type(): Type =
            env.resolve(symbol)?.type() ?: throw Exception("resolve symbol: $symbol in environment: $env")

    override fun eval(): Value = env.resolve(symbol)?.eval()
            ?: throw Exception("resolving \"$symbol\" in environment $env")
}

data class UnaryExpr(val op: Operator, val operand: Expr) : Expr() {
    override fun eval(): Value {
        val operandValue = operand.eval()
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
    override fun eval(): Value {
        val (first, second) = Pair(firstOperand.eval(), secondOperand.eval())
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
        val (firstType, secondType) = Pair(firstOperand.type(), secondOperand.type())
        return when (op) {
            in listOf("+", "-", "*", "/", "%") ->
                if (firstType == IntType && secondType == IntType) IntType
                else throw Exception("Int type operators expected for $op," +
                        "$firstType and $secondType found")
            in listOf(">", ">=", "<", "<=") ->
                if (firstType == IntType && secondType == IntType) BoolType
                else throw Exception("Int type operators expected for $op," +
                        "$firstType and $secondType found")
            else ->
                if (firstOperand.type() == BoolType && secondOperand.type() == BoolType) BoolType
                else throw Exception("bool type operators expected for $op," +
                        " $firstType and $secondType found")
        }
    }
}

data class BlockExpr(val statements: List<Statement> = mutableListOf()) : Expr() {
    override fun type(): Type = (statements.last() as Expr).type()

    override fun eval(): Value {
        (0 until statements.size - 1).forEach { statements[it].execute() }
        return (statements.last() as Expr).eval()
    }
}

// if ( condition ) passExpr else elseExpr
data class IfExpr(val condition: Expr, val passExpr: Expr, val elseExpr: Expr) : Expr() {
    override fun type(): Type {
        val passType = passExpr.type()
        val elseType = elseExpr.type()
        if (passType != elseExpr) {
            throw Exception("different types in if expresion: pass type $passType, else type $elseType")
        }
        return elseType
    }

    override fun eval(): Value {
        if (condition.type() != BoolType) {
            throw Exception("bool type expected in if condition, ${condition.type()} found")
        }
        return if (condition.eval() == BoolValue(true)) {
            passExpr.eval()
        } else {
            elseExpr.eval()
        }
    }
}

data class FuncCallExpr(val func: Expr, val arguments: List<Expr> = listOf()) : Expr() {
    override fun type(): Type {
        TODO("Not yet implemented")
    }

    override fun eval(): Value {
        val f = func.eval() as FuncValue
        val parameterNames = f.parameter.map { it.key }

        // put arguments into this function's environment
        parameterNames.zip(arguments.map { it.eval() }
                // NOTE: instead of just arguments, so Euphonium applies eager eval
        ).forEach { f.env.define(it.first, it.second) }

        return f.body.eval() // eval in its own environment(the captured one from which the function is defined)
    }
}
