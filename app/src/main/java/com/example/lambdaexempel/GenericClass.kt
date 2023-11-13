package com.example.lambdaexempel

class GenericClass<T> (val t:T){
    
    
    fun print(){
        println("t = ${t}")
    }
}