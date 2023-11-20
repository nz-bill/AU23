package com.example.threadsexempel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.threadsexempel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var myThread: MyThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myThread = MyThread(binding)

        binding.button.setOnClickListener {
            if(myThread.isAlive){
                myThread.stopThread()

            }
            myThread = MyThread(binding)
            println("knapp tryckt")
            myThread.start()

        }


    }
}