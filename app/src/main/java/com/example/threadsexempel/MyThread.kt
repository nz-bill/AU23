package com.example.threadsexempel

import android.os.Handler
import android.os.Looper
import com.example.threadsexempel.databinding.ActivityMainBinding

class MyThread(val binding: ActivityMainBinding): Thread() {

    private var shouldStop = false

    override fun run() {
//        var  i = 1
//        while (!shouldStop && i < 10){
//            println("$name : $i")
//                sleep(500)
//            i++
//        }

        for (i in 1..10){
            if(!shouldStop){

                Handler(Looper.getMainLooper()).post {
                    updateUI(i)
                }
                println("$name : $i")
                sleep(500)
            }

        }

    }

    private fun updateUI(progress: Int) {
        if (progress < 10){
            binding.textView.text = "loading..."
            binding.progressBar.progress = progress
        } else {
            binding.progressBar.progress = progress
            binding.textView.text = "klar!"
        }
    }

    fun stopThread(){
        shouldStop = true
    }
}