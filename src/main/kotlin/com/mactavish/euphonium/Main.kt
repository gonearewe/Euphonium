package com.mactavish.euphonium

import com.mactavish.euphonium.parser.Parser


fun main(){
    val code=
        """fun main(x:String,y:Int):Int={
                let x:Int = 1;
                print(x);
            }
        """
    Parser().parse(code)
}


