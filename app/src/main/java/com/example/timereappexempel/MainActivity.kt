package com.example.timereappexempel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timereappexempel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var elapsedTime = 0L
    lateinit var timer:TimerThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        timer = TimerThread(this)
        binding.buttonStart.setOnClickListener {

            if(timer.isAlive){
                timer.stopTimer()
                binding.buttonStart.text = "start"
            } else {
                binding.buttonStart.text = "stop"
                timer = TimerThread(this)
                timer.start()
            }

        }

        binding.buttonReset.setOnClickListener {
            elapsedTime = 0
            binding.textView.text = "0"
        }


    }
}