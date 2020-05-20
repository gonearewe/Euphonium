package com.mactavish.euphonium

import com.mactavish.euphonium.ast.EuphoniumLexer
import com.mactavish.euphonium.ast.EuphoniumParser
import com.mactavish.euphonium.parser.Listener
import com.mactavish.euphonium.parser.Parser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeWalker


fun main(){
    val code=
        """fun main(x:String,y:Int):Int={
                let x:Int = 1;
                print(x);
            }
        """
    Parser().parse(code)
}


