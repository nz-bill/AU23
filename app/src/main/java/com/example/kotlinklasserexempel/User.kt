package com.example.kotlinklasserexempel

class User {

    var name: String get() {
       return field
    }
       set(value) {}
    var age: Int
        get() {
            return field
        }
        private set(value) {
            field = value
        }

    constructor( name : String,  age: Int){
        this.name = name
        this.age = age

    }

}