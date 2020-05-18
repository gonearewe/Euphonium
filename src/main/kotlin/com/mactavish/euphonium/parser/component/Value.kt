package com.mactavish.euphonium.parser.component

sealed class Value

data class IntValue(val i:Int):Value()

data class StringValue(val s:String):Value()

data class BoolValue(val b:Boolean):Value()

object UnitValue : Value()

data class FuncValue(val parameter:List<Value>,val retType:Type):Value()
