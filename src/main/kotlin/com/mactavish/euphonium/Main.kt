package com.mactavish.euphonium

import com.mactavish.euphonium.parser.Parser


fun main(){
    val code=
        """fun main(x:String,y:Int):Int={
                let y:Int = x/8+9-23/(11%2-8+9*1);
                let x:String = "ss/n/t";
                print(!true&&false||true||(!true&& y>=28 ));
            }
        """
    Parser().parse(code)
}


