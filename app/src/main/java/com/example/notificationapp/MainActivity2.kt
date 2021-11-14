package com.example.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notificationapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_main2)
    }
}