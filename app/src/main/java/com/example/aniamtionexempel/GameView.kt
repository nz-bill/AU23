package com.example.aniamtionexempel

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context): SurfaceView(context),SurfaceHolder.Callback, Runnable {

    var thread: Thread? = null
    var running = false
    lateinit var canvas: Canvas
    lateinit var ball1: Ball
    lateinit var ball2: Ball
    var mHolder : SurfaceHolder? = holder

    init {
        if (mHolder != null){
            mHolder?.addCallback(this)
        }

        setup()
    }

    private fun setup() {
        ball1 = Ball(this.context)
        ball2 = Ball(this.context)
        ball1.posX = 100f
        ball1.posY = 100f
        ball2.posX =500f
        ball2.speed = 0f
        ball2.posY = 400f
        ball1.paint.color = Color.RED
        ball2.paint.color = Color.GREEN
    }

    fun start(){
        running = true
        thread = Thread(this)
        thread?.start()
    }

    fun stop(){
        running = false
        thread?.join()
    }

    fun update(){
        ball1.update()
        ball2.update()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        ball2.posX = event!!.x
        ball2.posY = event!!.y

        return true
    }

    fun draw(){

            canvas = holder!!.lockCanvas()
            canvas.drawColor(Color.BLUE)
            ball1.draw(canvas)
            ball2.draw(canvas)
            holder!!.unlockCanvasAndPost(canvas)


    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
       stop()
    }

    override fun run() {
      while (running){
          update()
          draw()
      }
    }
}