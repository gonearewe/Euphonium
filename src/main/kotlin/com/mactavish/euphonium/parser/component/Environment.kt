package com.mactavish.euphonium.parser.component

typealias Symbol = String

class Environment private constructor(private val table: MutableMap<Symbol, Expr> = HashMap()) {
    private var parent: Environment? = null

    companion object {
        fun newGlobalEnvironment(): Environment = Environment()
        fun newUndefinedEnvironment(): Environment = Environment()
    }

    fun newChildEnvironment(table: MutableMap<Symbol, Expr> = HashMap()): Environment =
            Environment(table).also { it.parent = this }

    // try to resolve by itself, turn to parent if failed
    fun resolve(symbol: Symbol): Expr? = table[symbol] ?: parent?.resolve(symbol)

    fun define(symbol: Symbol, expr: Expr) {
        table[symbol] = expr
    }

    override fun toString(): String {
        return "Environment(${table.keys})"
    }
}
