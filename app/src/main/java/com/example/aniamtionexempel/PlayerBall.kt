package com.example.aniamtionexempel

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class PlayerBall(
    context: Context, posX: Float, posY: Float, size: Float, speedX: Float, speedY: Float, color: Int)
    : Ball(context, posX, posY, size, speedX, speedY, color) {

    var bitmap:Bitmap
    init {
        bitmap = BitmapFactory.decodeResource(context.resources,R.drawable.dude)
    }

    override fun draw(canvas: Canvas?) {
        val centerX = posX - bitmap.width/2
        val centerY = posY - bitmap.height/2
        canvas?.drawBitmap(bitmap,centerX,centerY,null)
    }
}