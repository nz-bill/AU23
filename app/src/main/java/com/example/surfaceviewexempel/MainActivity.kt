package com.example.surfaceviewexempel

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import com.example.surfaceviewexempel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SurfaceHolder.Callback, View.OnTouchListener {

    var circleX = 300f
    var circleY = 600f
    val ballPaint = Paint()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.surfaceView.holder.addCallback(this)
        binding.surfaceView.setOnTouchListener(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }

    fun drawBall(){
        val canvas: Canvas? =binding.surfaceView.holder.lockCanvas()
        val surfaceBackground = Paint()
        surfaceBackground.color = Color.YELLOW
        canvas?.drawColor(Color.BLUE)
        ballPaint.color = Color.RED
        canvas?.drawCircle(circleX,circleY,100f,ballPaint)
        canvas?.drawRect(50f,50f,binding.surfaceView.width.toFloat()-50,binding.surfaceView.height.toFloat()-50,surfaceBackground)




        binding.surfaceView.holder.unlockCanvasAndPost(canvas)

        binding.surfaceView.setZOrderOnTop(true)


    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        if (v is SurfaceView){
           circleX = event?.x as Float
           circleY = event?.y as Float


//            if(x != null){
//                circleX = x
//            }
//
//            if(y != null){
//                circleY = y
//            }


            drawBall()
            return true
        } else return false

    }
}