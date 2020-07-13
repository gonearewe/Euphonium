package com.mactavish.euphonium

import com.mactavish.euphonium.parser.Parser


fun main(){
    val code =
            """fun main()=
                if(5>1+2) {println(8-9*2);}
                else {println(1);}
            
        """
    Parser().parse(code).eval()
}


