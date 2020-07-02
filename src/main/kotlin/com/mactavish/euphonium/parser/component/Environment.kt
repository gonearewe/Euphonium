package com.mactavish.euphonium.parser.component

typealias Symbol=String
class Environment private constructor(private val table: MutableMap<Symbol, Expr> = HashMap()) {
    private var parent:Environment= this

    companion object{
        fun newGlobalEnvironment(): Environment = Environment()
        fun newUndefinedEnvironment(): Environment = Environment()
    }

    fun newChildEnvironment(table: MutableMap<Symbol, Expr> =HashMap()):Environment=
            Environment(table).also { it.parent=this }

    fun resolve(symbol: Symbol)= table[symbol]

    fun define(symbol: Symbol,expr: Expr){
        table[symbol]=expr
    }
}
