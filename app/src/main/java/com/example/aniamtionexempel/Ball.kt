package com.example.aniamtionexempel

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

open class Ball(context: Context, var posX:Float, var posY:Float, var size:Float, var speedX: Float, var speedY:Float,color: Int) {


    var paint = Paint()
    init {
        paint.color = color
    }

    fun checkBounds(bounds: Rect){
        if(posX-size < bounds.left || posX+size > bounds.right){
            speedX *= -1
            posX += speedX*1.2f
        }
        if(posY-size < bounds.top || posY+size > bounds.bottom){
            speedY *= -1
            posY += speedY*1.2f
        }

    }
    fun update(){
        posX += speedX
        posY += speedY
    }

   open fun draw(canvas: Canvas?){
        canvas?.drawCircle(posX,posY,size,paint)
    }
}