package com.mactavish.euphonium.parser

import com.mactavish.euphonium.ast.EuphoniumLexer
import com.mactavish.euphonium.ast.EuphoniumParser
import com.mactavish.euphonium.evaler.Evaler
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class Parser {
    fun parse(s: String): Evaler {
        val lexer = EuphoniumLexer(CharStreams.fromString(s))
        val tokens = CommonTokenStream(lexer)
        val parser = EuphoniumParser(tokens)
        parser.buildParseTree = true // tell ANTLR to build a parse tree

        val tree: ParseTree = parser.fundecl()

        val v = Visitor()
        v.visit(tree)
        return Evaler(v.globalEnvironment)
    }
}
