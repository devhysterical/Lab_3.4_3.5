package com.example.customviewsui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var currentBorderStyle = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.customButton)

        // Sự kiện khi nhấn Button
        button.setOnClickListener {
            // Thay đổi kiểu đường viền sau mỗi lần nhấn
            val drawable = createNextBorderStyle()
            button.background = drawable
        }
    }

    // Tạo GradientDrawable với kiểu đường viền khác nhau
    private fun createNextBorderStyle(): GradientDrawable {
        val randomColor = getRandomColor()
        val borderColor = getRandomColor()
        val borderWidth = 6

        val gradientDrawable = GradientDrawable()

        when (currentBorderStyle) {
            0 -> {
                // Đường viền hình chữ nhật có góc bo
                gradientDrawable.shape = GradientDrawable.RECTANGLE
                gradientDrawable.setCornerRadius(50f)
            }
            1 -> {
                // Đường viền hình oval
                gradientDrawable.shape = GradientDrawable.OVAL
            }
            2 -> {
                // Đường viền hình chữ nhật không bo góc
                gradientDrawable.shape = GradientDrawable.RECTANGLE
            }
        }

        // Cập nhật màu nền và đường viền
        gradientDrawable.setColor(randomColor) // Màu nền
        gradientDrawable.setStroke(borderWidth, borderColor) // Đường viền

        // Cập nhật kiểu đường viền cho lần nhấn kế tiếp
        currentBorderStyle = (currentBorderStyle + 1) % 3

        return gradientDrawable
    }

    // Hàm tạo màu ngẫu nhiên
    private fun getRandomColor(): Int {
        val random = Random
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}
