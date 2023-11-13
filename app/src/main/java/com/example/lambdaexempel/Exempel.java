package com.example.lambdaexempel;

public class Exempel {

    public void exempel(){
        JavaVersion add = (a, b) -> a+b;


        System.out.println("add java = " + add.operate(10,5));
    }
}
//val add = JavaVersion{a,b->a+b}