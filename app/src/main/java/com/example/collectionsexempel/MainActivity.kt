package com.example.collectionsexempel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.PriorityQueue
import java.util.Queue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myList =listOf("Hej","hello","tjena","hej då")

        val myArrayList = ArrayList<String>()



        val myMutableList = mutableListOf<String>()

        myList.forEach{myMutableList.add(it)}

        myMutableList.add("en till rad")



        val mySet = setOf("Hej","hello","tjena","hej då")

        val myMutableSet = mutableSetOf("arne", "bill", "bosse", "abraham", "bill","bill")

        val myHashSet = hashSetOf("arne", "bill", "bosse", "abraham")


        val mySortedSet = sortedSetOf("arne", "bill", "bosse", "abraham")


        val myQueue = PriorityQueue<String>()

        myQueue.addAll(myMutableSet)
        val myDeque = ArrayDeque<String>()
        myDeque.addAll(myMutableSet)
        val nextPerson = myDeque.first()



        println("myDeque = ${myDeque}")
        println("nextPerson = ${nextPerson}")


        myQueue.add("bill")



        val myMap = HashMap<String, String>()

        myMap["name"] = "bill"
        myMap["adress"] = "en gata"

        println("myMap = ${myMap}")




//        println("myQueue = ${myQueue.poll()}")
//        println("myQueue = ${myQueue}")



//        println("myMutableSet = ${myMutableSet}")
//        println("myHashSet = ${myHashSet}")
//        println("mySortedSet = ${mySortedSet}")

//        println("myList = $myList")
//        println("myMutableList = ${myMutableList}")


    }
}