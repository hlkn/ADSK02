package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addSomeViews(3)
    }
    fun addSomeViews(count: Int) {
        var my_layout = findViewById<LinearLayout>(R.id.my_layout)
        for (i in 1..count) {
            val textView = TextView(this)
            textView.text = "Hey, learner # $$i"
            textView.textSize = 20f
            my_layout.addView(textView)
        }
        val button = Button(this)
        button.text = "Click me!"
        button.setOnClickListener {
            addSomeViews(10)
        }
        my_layout.addView(button)
    }
}