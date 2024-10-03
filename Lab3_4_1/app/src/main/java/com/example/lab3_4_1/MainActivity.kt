package com.example.lab3_4_1

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewContainer: LinearLayout
    private var textViewCount = 0  // Đếm số lượng TextView đã được thêm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Liên kết các thành phần giao diện
        val addTextViewButton: Button = findViewById(R.id.addTextViewButton)
        val removeTextViewButton: Button = findViewById(R.id.removeTextViewButton)
        textViewContainer = findViewById(R.id.textViewContainer)

        // Xử lý sự kiện khi nhấn nút "Thêm TextView"
        addTextViewButton.setOnClickListener {
            addTextView()
        }

        // Xử lý sự kiện khi nhấn nút "Xóa TextView"
        removeTextViewButton.setOnClickListener {
            removeTextView()
        }
    }

    // Hàm để thêm TextView động
    private fun addTextView() {
        textViewCount++  // Tăng số lượng TextView
        val textView = TextView(this)
        textView.text = "TextView $textViewCount"
        textView.textSize = 18f

        // Thêm TextView vào container
        textViewContainer.addView(textView)
    }

    // Hàm để xóa TextView cuối cùng
    private fun removeTextView() {
        val childCount = textViewContainer.childCount
        if (childCount > 0) {
            // Xóa TextView cuối cùng
            textViewContainer.removeViewAt(childCount - 1)
            textViewCount--  // Giảm số lượng TextView
        }
    }
}