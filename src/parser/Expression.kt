package parser

import lexer.Token
import lexer.isIntegerOperator
import java.io.File

open class Expression {

}

class IntegerExpression private constructor(
        val operator: Token? = null,
        val firstOperand: IntegerExpression? = null,
        val secondExpression: IntegerExpression? = null,
        val value: Token? = null
) : Expression() {


    companion object {
        fun of(expr: List<Token>): IntegerExpression {
            if (expr.size == 1) {
                return IntegerExpression(value = expr[0])
            }
            if (isWrappedWithBracket(expr)) {
                return of(expr.subList(1, expr.size - 1))
            }

//            val newExpr = resolveMinus(expr)
            val splitPoint = indexOfLeastPriorityOperator(expr)
            return IntegerExpression(
                    expr[splitPoint],
                    of(expr.subList(0, splitPoint)),
                    of(expr.subList(splitPoint + 1, expr.size))
            )
        }
    }

    override fun toString(): String {
        if (value != null) {
            return value.value + " "
        }

        return buildString {
            append(operator!!.value)
            append(" ")
            if (firstOperand != null) {
                append(firstOperand.toString())
            } else {
                append("null ")
            }

            if (secondExpression != null) {
                append(secondExpression.toString())
            } else {
                append("null ")
            }
        }
    }
}

//private fun resolveMinus(expr: String) = buildString {
//    for (i in expr.indices) {
//        if (expr[i] != '-') {
//            append(expr[i])
//            continue
//        }
//
//        if (i == 0 || expr[i - 1] == '(') {
//            append("0-")
//        }
//    }
//}

private fun indexOfLeastPriorityOperator(expr: List<Token>): Int {
    val priorityTable = hashMapOf<String, Int>(
            "-" to 0, "+" to 0,
            "*" to 1, "/" to 1
    )

    var res = -1
    var currentPriority = 1024
    var bracketStack = 0
    for ((index, token) in expr.withIndex()) {
        if (token.value == "(") {
            bracketStack++
            continue
        }
        if (token.value == ")") {
            bracketStack--
            continue
        }
        if (bracketStack != 0) {
            continue
        }

        if (token.isIntegerOperator()) {
            if (priorityTable[token.value]!! < currentPriority) {
                currentPriority = priorityTable[token.value]!!
                res = index
            }
        }
    }

    assert(res >= 0)
    return res
}

private fun isWrappedWithBracket(expr: List<Token>): Boolean {
    if (expr.first().value != "(" || expr.last().value != ")") {
        return false
    }
    var bracketStack = 0
    expr.forEachIndexed { index: Int, it: Token ->
        if (it.value == "(") {
            bracketStack++
        }
        if (it.value == ")") {
            bracketStack--
            if (bracketStack == 0 && index != expr.size - 1) {
                return false
            }
        }
    }

    return true
}

fun main() {
    val lines = File("D:\\MyProjects\\Aurora\\test\\resource\\parser.txt").readLines()
    var i = 0
    while (i != lines.size) {
        if (i != 31) {
            i++
            continue
        }
        val line = lines[i]
        if (line.startsWith("#") || line.isBlank()) {
            i++
            continue
        }

        val case = ArrayList<Token>()
        line.split(" ").forEach {
            case.add(Token(it, ""))
        }

        val nextLine = lines[i + 1]
        // TEST
        assert(IntegerExpression.of(case).toString() == nextLine)
        // TEST
        i += 2
    }
    println("TEST PASSED")
//    val values= arrayOf("-5","+","3","*","6","/","(","2","+","3",")")
//    val tokens=ArrayList<Token>()
//    values.forEach {
//        tokens.add(Token(it,""))
//    }
//   println(IntegerExpression.of(tokens).toString())

}