package com.example.lab3_4_2

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dynamicContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Liên kết các thành phần giao diện
        val addViewButton: Button = findViewById(R.id.addViewButton)
        val removeAllButton: Button = findViewById(R.id.removeAllButton)
        dynamicContainer = findViewById(R.id.dynamicContainer)

        // Thiết lập sự kiện khi nhấn nút "Thêm thành phần"
        addViewButton.setOnClickListener {
            addTextView()
        }

        // Thiết lập sự kiện khi nhấn nút "Xóa tất cả"
        removeAllButton.setOnClickListener {
            removeAllTextViews()
        }
    }

    // Hàm để thêm TextView từ XML bằng LayoutInflater
    private fun addTextView() {
        // Nạp giao diện từ XML
        val inflater = LayoutInflater.from(this)
        val textView = inflater.inflate(R.layout.text_view_item, dynamicContainer, false)
        // Thêm TextView vào dynamicContainer
        dynamicContainer.addView(textView)
    }

    // Hàm để xóa tất cả các TextView đã thêm
    private fun removeAllTextViews() {
        // Xóa tất cả các View con trong dynamicContainer
        dynamicContainer.removeAllViews()
    }
}