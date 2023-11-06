package com.example.jsonexempel

class User(val name:String, val salary: Int) {


    fun toJSon(): String{
        return "{\"name\":\"$name\", \"salary\":$salary}"
    }

    override fun toString(): String {
        return "User(name='$name', salary=$salary)"
    }

}