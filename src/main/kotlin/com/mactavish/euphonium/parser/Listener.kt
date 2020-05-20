package com.mactavish.euphonium.parser

import com.mactavish.euphonium.ast.EuphoniumBaseListener
import com.mactavish.euphonium.ast.EuphoniumParser

class Listener() : EuphoniumBaseListener(){
    override fun enterFundecl(ctx: EuphoniumParser.FundeclContext?) {
        println(ctx?.ID())
        println(ctx?.TYPE())
        println(ctx?.expr())
    }
}
