package com.example.lambdaexempel

class Interfaces {

    fun interface MyInterface{
        fun sayHello():String
    }

    fun interface MyOneParameterInterface{
        fun incrementByFive(a: Int):Int
    }

    fun interface StringConcat{
        fun sconcat(a:String, b:String):String
    }
}