package parser

import lexer.Token
import lexer.isOperator
import java.io.File
import java.util.logging.Logger

class Expression private constructor(
        val operator: Token? = null,
        val firstOperand: Expression? = null,
        val secondExpression: Expression? = null,
        val value: Token? = null,
        val funcName: Token? = null,
        val funcParams: List<Expression>? = null
) {
    companion object {
        fun of(expr: List<Token>): Expression? {
            val logger = Logger.getLogger(Expression::javaClass.name)
            if (expr.isEmpty()) {
                return null
            }
            if (expr.size == 1) { // single literal or variable
                return Expression(value = expr[0])
            }
            if (isWrappedWithBracket(expr)) { // the whole expression is wrapped with a pair of brackets
                return of(expr.subList(1, expr.size - 1))
            }

//            val newExpr = resolveMinus(expr)
            val splitPoint = indexOfLeastPriorityOperator(expr)
//            if(splitPoint==-1){
//                logger.info("split point is -1 while tokens are:\n$expr")
//            }

            if (splitPoint == -1 && expr[0].type == "identifier" && expr[1].value == "(") { // function call expression
                return funcCallOf(expr)
            }
            return Expression(
                    expr[splitPoint],
                    of(expr.subList(0, splitPoint)),
                    of(expr.subList(splitPoint + 1, expr.size))
            )
        }

        private fun funcCallOf(expr: List<Token>): Expression {
            val name = expr[0]
            val params = ArrayList<Expression>()
            var tokens = ArrayList<Token>()
            var bracketStack = 0
            for (i in 2 until expr.size - 1) {
                bracketStack = when (expr[i].value) {
                    "(" -> bracketStack + 1
                    ")" -> bracketStack - 1
                    else -> bracketStack
                }

                if (bracketStack == 0 && expr[i].value == ",") {
                    params.add(of(tokens)!!)
                    tokens = ArrayList<Token>()
                } else {
                    tokens.add(expr[i])
                }
            }
            if (tokens.isNotEmpty()) {
                params.add(of(tokens)!!)
            }

            return Expression(funcName = name, funcParams = params)
        }
    }

    override fun toString(): String {
        if (value != null) {
            return value.value + " "
        }

        if (funcName != null) {
            return buildString {
                append(funcName.value + "(")
                funcParams!!.forEachIndexed { index, it ->
                    append("$it")
                    if (index != funcParams.size - 1) {
                        append(", ")
                    }
                }
                append(") ")
            }
        }

        return buildString {
            append(operator!!.value)
            append(" ")
            if (firstOperand != null) {
                append(firstOperand.toString())
            }

            if (secondExpression != null) {
                append(secondExpression.toString())
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
            "||" to 0, "&&" to 1, "!" to 2,
            "==" to 3, "!=" to 3,
            ">" to 4, "<" to 4, ">=" to 4, "<=" to 4,
            "!" to 5,
            "-" to 6, "+" to 6,
            "*" to 7, "/" to 7
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

        if (token.isOperator()) {
            if (priorityTable[token.value]!! <= currentPriority) {
                currentPriority = priorityTable[token.value]!!
                res = index
            }
        }
    }

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
    val lines = File("D:\\MyProjects\\Aurora\\test\\resource\\VariableAndFuncCallExpression.txt").readLines()
    var i = 0
    while (i != lines.size) {
        val line = lines[i]
        if (line.startsWith("#") || line.isBlank()) {
            i++
            continue
        }

        val case = ArrayList<Token>()
        line.split(" ").forEach {
            val type = when {
                it == "(" || it == ")" || it == "," -> "separator"
                it[0].isLetter() -> "identifier"
                else -> ""
            }
            case.add(Token(it, type))
        }

        val nextLine = lines[i + 1]
        // TEST
        val output = Expression.of(case).toString().trim() // trim spaces
        if (output != nextLine) {
            println("input: $line")
            println("expecting: $nextLine (string len: ${nextLine.length} )")
            println("found: $output (string len: ${output.length} )")
            return
        }
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