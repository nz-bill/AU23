package com.example.timereappexempel

import android.os.Handler
import android.os.Looper

class TimerThread(val activity: MainActivity): Thread() {

    var shouldStop = false
    override fun run() {

        while (!shouldStop){
            sleep(1000)
            activity.elapsedTime +=1

            updateUi()
            println(activity.elapsedTime)

        }


    }

    fun updateUi(){
        Handler(Looper.getMainLooper()).post {
            activity.binding.textView.text = activity.elapsedTime.toString()
        }
    }

    fun stopTimer(){
        shouldStop = true
    }
}