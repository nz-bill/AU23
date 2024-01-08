package com.example.coroutinetimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinetimer.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var remainingTime = 0L
    var job : Job? = null
    var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStop.isEnabled = false
        binding.btnPause.isEnabled = false

        binding.btnStart.setOnClickListener {
            startTimer()
        }

        binding.btnPause.setOnClickListener {
            if (!isPaused){
                pauseTimer()
            }else {
                resumeTimer()
            }

        }

        binding.btnStop.setOnClickListener {
            stopTimer()
        }
    }

    private fun pauseTimer() {
       isPaused = true
        binding.btnPause.text = "Resume"
    }

    private fun resumeTimer() {
        isPaused = false
        binding.btnPause.text = "Pause"
    }

    private fun stopTimer() {
       job?.cancel()
//        binding.tvOutput.text = "Timer stopped"

        binding.btnStart.isEnabled = true
        binding.btnStop.isEnabled = false
        binding.btnPause.isEnabled = false
    }

    private fun startTimer() {
        val inputTime = binding.etInput.text.toString().toLong()
        isPaused = false
        job = CoroutineScope(Dispatchers.Default).launch {

            withContext(Dispatchers.Main){
                binding.btnStart.isEnabled = false
                binding.btnStop.isEnabled = true
                binding.btnPause.isEnabled = true
            }
                remainingTime = inputTime


            while (remainingTime > 0){
                if(isPaused){
                    delay(1000)
                } else{
                    updateUi(remainingTime)
                    delay(1000)
                    remainingTime --
                }

            }
            updateUi(remainingTime)
        }

            binding.btnStart.isEnabled = true
            binding.btnStop.isEnabled = false
        binding.btnPause.isEnabled = false

    }

     private suspend fun updateUi(time: Long){
        withContext(Dispatchers.Main){
            binding.tvOutput.text = "Time remaining: ${time}"
        }

    }
}