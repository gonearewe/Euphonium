package com.mactavish.euphonium.evaler

import com.mactavish.euphonium.parser.component.*

class Evaler(private val globalEnvironment: Environment) {
    fun eval() {
        val env = Environment.newGlobalEnvironment()
        globalEnvironment.define("println", FuncValue(
                parameter = mapOf("v" to IntType),
                retType = UnitType,
                body = NativeExpr({ env ->
                    println(env.resolve("v"))
                    UnitValue
                }, env),
                env = env
        ))
        FuncCallExpr(
                globalEnvironment.resolve("main") ?: throw Exception("main function is not found")
        ).eval().also { println(it) }
    }
}
