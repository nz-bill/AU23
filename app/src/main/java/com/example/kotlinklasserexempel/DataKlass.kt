package com.example.kotlinklasserexempel

import java.io.Serializable

data class DataKlass (val name:String, val age: Int, val email: String , val phone:String): Serializable{
}