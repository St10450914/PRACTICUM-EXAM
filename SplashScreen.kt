package com.example.practicumexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val btn_start = findViewById<Button>(R.id.btn_start)
        val btn_exit = findViewById<Button>(R.id.btn_exit)

        btn_start.setOnClickListener {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        }
        btn_exit.setOnClickListener {
            finish() // Close the activity properly
        }
    }
}