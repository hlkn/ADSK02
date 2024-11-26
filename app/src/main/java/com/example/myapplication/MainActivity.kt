package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.setTitle("Olive Branch")
        getSupportActionBar()?.show()
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayUseLogoEnabled(true)
            it.setLogo(R.drawable.ic_action_name)
        }
        binding.imageSwitch.setOnCheckedChangeListener { _, isChecked ->
            //binding.imageView.visibility = if (isChecked) View.VISIBLE else View.GONE
            if (isChecked) {
                binding.imageView.load("https://bitly.com/android_dev_image1")
                binding.textView.text = "https://bitly.com/android_dev_image1"
            }
            else {
                binding.imageView.load("https://bitly.com/android_dev_image2")
                binding.textView.text = "https://bitly.com/android_dev_image2"
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}