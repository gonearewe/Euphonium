package com.mactavish.euphonium.evaler

import com.mactavish.euphonium.parser.component.Environment
import com.mactavish.euphonium.parser.component.FuncCallExpr
import com.mactavish.euphonium.parser.component.IntValue
import com.mactavish.euphonium.parser.component.StringValue

class Evaler(private val globalEnvironment: Environment) {
    fun eval() {
        FuncCallExpr(
                globalEnvironment.resolve("main") ?: throw Exception("main function is not found"),
                listOf(StringValue("arg"), IntValue(45))
        ).evalIn().also { println(it) }
    }
}
