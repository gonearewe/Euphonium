package com.mactavish.euphonium.parser.component

sealed class Statement

sealed class Declaration:Statement()

// VarDeclaration represents the declaration of ordinary variables and non-toplevel functions.
data class VarDeclaration(val symbol: Symbol,val expr: Expr):Declaration()
// FuncDeclaration represents the declaration of toplevel functions.
data class FuncDeclaration(val symbol: Symbol,val expr: Expr):Declaration()

abstract class Expr:Statement() {
    open fun type() :String =throw Exception("uninitialised expression type")
    abstract val value:Value
    open val children= mutableListOf<Expr>()
}

typealias Operator=String

data class LiteralExpr(override val value: Value):Expr()

data class UnaryExpr(val op:Operator,val operand:Value):Expr(){
    override val value:Value by lazy {
        when (op) {
            "+" -> operand
            "-" -> IntValue(-(operand as IntValue).i)
            "!" -> BoolValue(!(operand as BoolValue).b)
            else -> throw Exception("unresolved unary expression")
        }
    }
}

data class BinaryExpr(val op: Operator,val firstOperand: Value,val secondOperand:Value):Expr(){
    override val value: Value by lazy {
        val (first,second)=Pair(firstOperand,secondOperand)
        when(op){
            "=="->BoolValue(first==second)
            "!="-> BoolValue(first!=second)
            "&&"->BoolValue((first as BoolValue).b&&(second as BoolValue).b)
            "||"->BoolValue((first as BoolValue).b||(second as BoolValue).b)
            else->{
                val a=(first as IntValue).i
                val b=(second as IntValue).i
                 when(op){
                    ">="->BoolValue(a>=b)
                     ">"->BoolValue(a>b)
                     "<="->BoolValue(a<b)
                     "<"-> BoolValue(a<b)
                     "+"->IntValue(a+b)
                     "-"->IntValue(a-b)
                     "*"->IntValue(a*b)
                     "/"->IntValue(a/b)
                     "%"->IntValue(a%b)
                     else->throw Exception("unresolved binary expression")
                }
            }
        }
    }
}

data class BlockExpr(val statements: List<Statement> = mutableListOf()):Expr(){

}
