package com.mactavish.euphonium.parser

import com.mactavish.euphonium.ast.EuphoniumBaseVisitor
import com.mactavish.euphonium.ast.EuphoniumParser
import com.mactavish.euphonium.parser.component.*

class Visitor() : EuphoniumBaseVisitor<Statement>() {
    private val globalEnvironment = Environment.newGlobalEnvironment()

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
        val retType = ctx.TYPE().last().toString().let {
            when (it) {
                "Int" -> IntType
                "Bool" -> BoolType
                "String" -> StringType
                "Unit" -> UnitType
                else -> throw Exception("unknown return type $it in function ${ctx.text}")
            }
        }

        globalEnvironment.define(
                symbol = ctx.ID(0).toString(),
                expr = FuncValue(params, retType, visit(ctx.getChild(ctx.childCount - 1)) as Expr, globalEnvironment)
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
        if (ctx.children.first().text == "(" && ctx.children.last().text == ")") {
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
            return FuncCallExpr(visitChildExpr(0), (1 until ctx.expr().size).map { visitChildExpr(it) })
        }

        // ( expr ';' ) is also an expr
        if (ctx.children.last().text == ";") {
            return visit(ctx.expr(0))
        }

        return ctx.ID()?.let { VariableExpr(it.text) }
                ?: ctx.STRING()?.let { StringValue(it.text) }
                ?: ctx.INT()?.let { IntValue(it.text.toInt()) }
                ?: ctx.BOOL()?.let { BoolValue(it.text!!.toBoolean()) }
                ?: throw Exception("unknown expression: $ctx")
    }

    override fun visitExprStatement(ctx: EuphoniumParser.ExprStatementContext?): Statement = visitExpr(ctx?.expr())

    override fun visitVardecl(context: EuphoniumParser.VardeclContext?): Statement {
        val ctx = context!!

        return VarDeclaration(symbol = ctx.ID().text, expr = visit(ctx.expr()) as Expr)
    }
}