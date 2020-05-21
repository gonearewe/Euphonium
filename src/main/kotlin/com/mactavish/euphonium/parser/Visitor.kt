package com.mactavish.euphonium.parser

import com.mactavish.euphonium.ast.EuphoniumBaseListener
import com.mactavish.euphonium.ast.EuphoniumBaseVisitor
import com.mactavish.euphonium.ast.EuphoniumParser
import com.mactavish.euphonium.parser.component.*

class Visitor() : EuphoniumBaseVisitor<Statement>(){
    private val globalEnvironment=Environment.newGlobalEnvironment()
    private var currentFuncName:Symbol=""

    override fun visitFundecl(context: EuphoniumParser.FundeclContext?): Statement {
        val ctx=context!!

        // collect params
        val params= mutableListOf<Param>()
        for (i in 1 until ctx.ID().size){
            val paramName=ctx.ID(i).toString()
            val paramType=ctx.TYPE(i).toString()
            when(paramType){
                "Int"->Param(paramName,IntValue())
                "Bool"->Param(paramName,BoolValue())
                "String"->Param(paramName,StringValue())
                else->throw Exception("unknown type $paramType for $paramName in function ${ctx.text}")
            }.let {
                params.add(it)
            }
        }

        // extract return type
        val retType=ctx.TYPE().last().toString().let {
            when(it){
                "Int"->IntType
                "Bool"->BoolType
                "String"->StringType
                "Unit"->UnitType
                else->throw Exception("unknown return type $it in function ${ctx.text}")
            }
        }

        globalEnvironment.define(
                symbol = ctx.ID(0).toString(),
                expr = FuncExpr(params,retType,visit(ctx.getChild(ctx.childCount-1)) as Expr,globalEnvironment)
        )

        return UnitValue // we don't need the result of this visitor actually
    }

    override fun visitExpr(context: EuphoniumParser.ExprContext?): Statement {
        val ctx=context!!
//        when(ctx.)
        return UnitValue
    }
}
