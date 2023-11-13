package com.example.lambdaexempel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Collections


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val myList = listOf("bosse", "bill","arne","abraham")
//
//        myList.forEach{println(it)}
//
//        val msg = Interfaces.MyInterface { "hello" }
//
//        val f = Interfaces.MyOneParameterInterface{it+5}
//
//        val s = Interfaces.StringConcat { a, b -> a+"\\"+b }
//
//        println("f.incrementByFive(22) = ${f.incrementByFive(22)}")
//        println(msg.sayHello())
//
//        println("s.sconcat(\"hello \", \"world\") = ${s.sconcat("hello", "world")}")
//
//        val java = Exempel()
//
//        java.exempel()
    //uppgiften()

//        val button: Button = findViewById(R.id.btn)
//
//        button.setOnClickListener {
//
//        }

//generics()
        lambdaExempel()

    }

    fun lambdaExempel(){
        val nameList = mutableListOf("Bill","Bosse","Björn")


        println("nameList = ${nameList}")

        nameList.removeIf { it.length > 7 }

        nameList.sortWith{ a, b -> a.compareTo(b) }
        println("nameList = ${nameList}")
        nameList.sortWith{ a, b -> b.compareTo(a) }
        println("nameList = ${nameList}")

        nameList.forEach {  println("hej")
            println("it = ${it}")
           }

        for (name in nameList){
            println("hej")
            println("name = ${name}")
        }
    }

    fun generics(){
        val obj1 = GenericClass<Int>(10)
        val obj2 = GenericClass<String>("Hej")
        val obj3 = GenericClass<Double>(20.0)


        obj1.print()
        obj2.print()
        obj3.print()
    }

    fun uppgiften(){
        val add = JavaVersion{a,b->a+b}
        val sub = JavaVersion(){a,b->a-b}
        val multi = JavaVersion(){a,b-> a*b}
        val div = JavaVersion() {a,b ->
            if (b !=0) a/b
            else 0}




        println("add.operate(10,5) = ${add.operate(10,5)}")
        println("sub.operate(10,5) = ${sub.operate(10,5)}")
        println("multi.operate(10,5) = ${multi.operate(10, 5)}")
        println("div.operate(10,5) = ${div.operate(10, 5)}")
        println("div.operate(10,0) = ${div.operate(10,0)}")


    }

    fun interface Operator{
        fun operate(a:Int,b:Int):Int
    }


}