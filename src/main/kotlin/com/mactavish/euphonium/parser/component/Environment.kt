package com.mactavish.euphonium.parser.component

typealias Symbol=String
class Environment(private val table: MutableMap<Symbol, Expr> =HashMap()) {
    fun resolve(symbol: Symbol)= table[symbol]
    fun define(symbol: Symbol,expr: Expr){
        table[symbol]=expr
    }
}
