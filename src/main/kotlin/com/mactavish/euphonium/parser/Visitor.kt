package com.mactavish.euphonium.parser

import com.mactavish.euphonium.ast.EuphoniumBaseVisitor
import com.mactavish.euphonium.ast.EuphoniumParser
import com.mactavish.euphonium.parser.component.*
import org.antlr.v4.runtime.tree.ParseTree

class Visitor() : EuphoniumBaseVisitor<Statement>() {
    val globalEnvironment = Environment.newGlobalEnvironment()
    val environment = mutableListOf(globalEnvironment)

    private val currentEnvironment: Environment
        get() = environment.last() // computed field, update for each access

    private fun enterNewEnvironment() {
        environment.add(currentEnvironment.newChildEnvironment())
    }

    private fun exitCurrentEnvironment() {
        environment.removeAt(environment.size - 1)
    }


    override fun visit(tree: ParseTree?): Statement {
        synchronized(globalEnvironment) {
            return super.visit(tree)
        }
    }

    override fun visitFundecl(context: EuphoniumParser.FundeclContext?): Statement {
        val ctx = context!!

        // collect params
        val params = mutableMapOf<Symbol, Type>()
        for (i in 1 until ctx.ID().size) {
            val paramName = ctx.ID(i).toString()
            when (val paramType = ctx.TYPE(i).toString()) {
                "Int" -> params[paramName] = IntType
                "Bool" -> params[paramName] = BoolType
                "String" -> params[paramName] = StringType
                else -> throw Exception("unknown type $paramType for $paramName in function ${ctx.text}")
            }
        }

        // extract return type
        val retType = ctx.TYPE().last().toString().let { Type.of(it) }

        globalEnvironment.define(
                symbol = ctx.ID(0).toString(),
                expr = FuncValue(params, retType,
                        body = visit(ctx.getChild(ctx.childCount - 1)) as Expr,
                        env = globalEnvironment)
        )

        return UnitValue // we don't need the result of this visitor actually
    }

    override fun visitExpr(context: EuphoniumParser.ExprContext?): Statement {
        val ctx = context!!

        // block expr
        if (ctx.children.first().text == "{" && ctx.children.last().text == "}") {
            val statements = mutableListOf<Statement>()
            if (ctx.childCount >= 2) { // avoiding empty block body, two children mean '{' and '}'
                for (i in 1 until ctx.childCount - 1) { // list statements
                    statements.add(visit(ctx.getChild(i))) // collect statements in this block
                }
            }
            return BlockExpr(statements)
        }

        fun visitChildExpr(index: Int) = visit(ctx.expr(index)) as Expr

        // '(' expr ')'
        if (ctx.children.first().text == "(" && ctx.children.last().text == ")" && ctx.childCount == 3) {
            return visitChildExpr(0)
        }

        if (ctx.op?.text in listOf("-", "+", "!") && ctx.expr().size == 1) {
            return UnaryExpr(ctx.op?.text!!, visitChildExpr(0))
        }

        if (ctx.op?.text in listOf("*", "/", "%", "+", "-", ">", ">=", "<", "<=", "==", "!=", "&&", "||") && ctx.expr().size == 2) {
            return BinaryExpr(ctx.op?.text!!, visitChildExpr(0), visitChildExpr(1))
        }

        if (ctx.children.first().text == "if") {
            return IfExpr(visitChildExpr(0), visitChildExpr(1), visitChildExpr(2))
        }

        if (ctx.childCount >= 2 && ctx.children[1].text == "(" && ctx.children.last().text == ")") {
            if (ctx.childCount == 3) {
                return FuncCallExpr(visitChildExpr(0), listOf())
            }
            return FuncCallExpr(
                    func = visitChildExpr(0),
                    arguments = (1 until ctx.expr().size).map { visitChildExpr(it) }
            )
        }

        // ( expr ';' ) is also an expr
        if (ctx.children.last().text == ";") {
            return visit(ctx.expr(0))
        }

        // function value
        if ("=>" in ctx.children.map { it.text }) {
            return withinScope { newEnvironment ->
                val parameters = ctx.ID().map { it.text } zip List(ctx.ID().size) { UninferredType }
                val body = visit(ctx.expr(0)) as Expr
                FuncValue(parameters.toMap(), UninferredType, body, newEnvironment)
            }
        }

        return ctx.ID(0)?.let { VariableExpr(it.text, currentEnvironment) }
                ?: ctx.STRING()?.let { StringValue(it.text) }
                ?: ctx.INT()?.let { IntValue(it.text.toInt()) }
                ?: ctx.BOOL()?.let { BoolValue(it.text!!.toBoolean()) }
                ?: throw Exception("unknown expression: $ctx")
    }

    override fun visitExprStatement(ctx: EuphoniumParser.ExprStatementContext?): Statement = visitExpr(ctx?.expr())

    override fun visitVardecl(context: EuphoniumParser.VardeclContext?): Statement {
        val ctx = context!!

        return VarDeclaration(symbol = ctx.ID().text, expr = visit(ctx.expr()) as Expr, env = currentEnvironment)
    }

    private fun <R> withinScope(block: (env: Environment) -> R): R {
        enterNewEnvironment()
        val ret = block(environment.last())
        exitCurrentEnvironment()
        return ret
    }
}
