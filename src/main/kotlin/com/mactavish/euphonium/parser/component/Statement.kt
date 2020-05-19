package com.mactavish.euphonium.parser.component

sealed class Statement{
    abstract fun type(env: Environment):Type
    abstract fun execute(env: Environment):Value
}

sealed class Declaration:Statement(){
    abstract val symbol:Symbol
    abstract val expr:Expr
    override fun execute(env: Environment): Value {
        env.define(symbol,expr)
        return UnitValue
    }
}

// VarDeclaration represents the declaration of ordinary variables and non-toplevel functions.
data class VarDeclaration(override val symbol: Symbol, override val expr: Expr):Declaration() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }
}

// FuncDeclaration represents the declaration of toplevel functions.
data class FuncDeclaration(override val symbol: Symbol, override val expr: Expr):Declaration() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }
}

sealed class Expr:Statement() {
    override fun execute(env: Environment): Value =evalIn(env)

    abstract fun evalIn(env: Environment):Value
//    open fun type() :String =throw Exception("uninitialised expression type")
//    abstract val value:Value
//    open val children= mutableListOf<Expr>()
}

typealias Operator=String

sealed class Value:Expr()

data class IntValue(val i:Int):Value() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(env: Environment): Value {
        TODO("Not yet implemented")
    }
}

data class StringValue(val s:String):Value() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(env: Environment): Value {
        TODO("Not yet implemented")
    }
}

data class BoolValue(val b:Boolean):Value() {
    override fun evalIn(env: Environment): Value {
        TODO("Not yet implemented")
    }

    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }
}

object UnitValue : Value() {
    override fun type(env: Environment): Type =UnitType

    override fun evalIn(env: Environment): Value =this
}

data class FuncValue(val parameter:List<Value>,val retType:Type):Value() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(env: Environment): Value {
        TODO("Not yet implemented")
    }
}

//data class LiteralExpr(override val value: Value):Expr()

data class VariableExpr(val symbol: Symbol):Expr() {
    override fun type(env: Environment): Type {
        TODO("Not yet implemented")
    }

    override fun evalIn(env: Environment): Value =env.resolve(symbol)?.evalIn(env)?:throw Exception()
}

//data class UnaryExpr(val op:Operator,val operand:Value):Expr(){
//    override val value:Value by lazy {
//        when (op) {
//            "+" -> operand
//            "-" -> IntValue(-(operand as IntValue).i)
//            "!" -> BoolValue(!(operand as BoolValue).b)
//            else -> throw Exception("unresolved unary expression")
//        }
//    }
//}
//
//data class BinaryExpr(val op: Operator,val firstOperand: Value,val secondOperand:Value):Expr(){
//    override val value: Value by lazy {
//        val (first,second)=Pair(firstOperand,secondOperand)
//        when(op){
//            "=="->BoolValue(first==second)
//            "!="-> BoolValue(first!=second)
//            "&&"->BoolValue((first as BoolValue).b&&(second as BoolValue).b)
//            "||"->BoolValue((first as BoolValue).b||(second as BoolValue).b)
//            else->{
//                val a=(first as IntValue).i
//                val b=(second as IntValue).i
//                 when(op){
//                    ">="->BoolValue(a>=b)
//                     ">"->BoolValue(a>b)
//                     "<="->BoolValue(a<b)
//                     "<"-> BoolValue(a<b)
//                     "+"->IntValue(a+b)
//                     "-"->IntValue(a-b)
//                     "*"->IntValue(a*b)
//                     "/"->IntValue(a/b)
//                     "%"->IntValue(a%b)
//                     else->throw Exception("unresolved binary expression")
//                }
//            }
//        }
//    }
//}
//
//data class BlockExpr(val statements: List<Statement> = mutableListOf()):Expr(){
//
//}
