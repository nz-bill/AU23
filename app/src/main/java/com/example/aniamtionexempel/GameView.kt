package com.example.aniamtionexempel

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class GameView(context: Context): SurfaceView(context),SurfaceHolder.Callback, Runnable {

    var thread: Thread? = null
    var running = false
    lateinit var canvas: Canvas
    lateinit var ball1: Ball
    lateinit var ball2: Ball
    var bounds = Rect()
    var mHolder : SurfaceHolder? = holder

    init {
        if (mHolder != null){
            mHolder?.addCallback(this)
        }

        setup()
    }

    private fun setup() {
        ball1 = Ball(this.context,100f,100f,20f,5f,5f, Color.RED)
       // ball2 = Ball(this.context,400f,100f,20f,0f,0f, Color.GREEN)

        ball2 = PlayerBall(this.context,400f,100f,32f,0f,0f, Color.GREEN)

    }

    fun onBallCollision(b1:Ball,b2:Ball){

    if(b1.posX < b2.posX && b1.posY < b2.posY){
        b1.speedX = abs(b1.speedX) * -1
        b1.speedY = abs(b1.speedY) * -1
    }
        if(b1.posX < b2.posX && b1.posY > b2.posY){
            b1.speedX = abs(b1.speedX) * -1
            b1.speedY = abs(b1.speedY)
        }
        if(b1.posX > b2.posX && b1.posY < b2.posY){
            b1.speedX = abs(b1.speedX)
            b1.speedY = abs(b1.speedY) * -1
        }
        if(b1.posX > b2.posX && b1.posY < b2.posY){
            b1.speedX = abs(b1.speedX)
            b1.speedY = abs(b1.speedY)
        }




    //        b1.speedX *= -1
//        b1.speedY *= -1
       // b2.paint.color = Color.YELLOW
    }


    fun ballIntersects(b1:Ball,b2:Ball){
        if(sqrt((b1.posX - b2.posX.toDouble()).pow(2.0) + (b1.posY - b2.posY.toDouble()).pow(2.0)) <= b1.size+b2.size){
            onBallCollision(b1,b2)
        }
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

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        bounds = Rect(0,0,width,height)
        start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
       stop()
    }

    override fun run() {
      while (running){
          update()
          draw()
          ball1.checkBounds(bounds)
          ballIntersects(ball1,ball2)


      }
    }
}