package com.mactavish.euphonium

import com.mactavish.euphonium.parser.Parser


fun main(){
    val code=
        """fun main(x:String,y:Int):Int={
                let add:(Int,Int)=>(Int)=(a,b)=>a+b;
                add(3,4);
            }
        """
    Parser().parse(code).eval()
}


