package com.example.customviewsui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.min
import kotlin.random.Random

class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var circleColor: Int = Color.RED  // Màu mặc định cho vòng tròn
    private val paint = Paint().apply {
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = min(width, height) / 2f  // Bán kính vòng tròn
        val centerX = width / 2f  // Tọa độ tâm X
        val centerY = height / 2f  // Tọa độ tâm Y

        paint.color = circleColor
        canvas.drawCircle(centerX, centerY, radius, paint)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            if (it.action == MotionEvent.ACTION_DOWN) {
                if (isTouchInsideCircle(it.x, it.y)) {
                    circleColor = getRandomColor()  // Đổi màu ngẫu nhiên
                    invalidate()  // Vẽ lại view với màu mới
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }

    // Hàm kiểm tra xem người dùng có nhấn trong phạm vi vòng tròn hay không
    private fun isTouchInsideCircle(x: Float, y: Float): Boolean {
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = min(width, height) / 2f
        val distance = Math.sqrt(((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY)).toDouble())
        return distance <= radius
    }

    // Hàm tạo màu ngẫu nhiên
    private fun getRandomColor(): Int {
        val random = Random
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}