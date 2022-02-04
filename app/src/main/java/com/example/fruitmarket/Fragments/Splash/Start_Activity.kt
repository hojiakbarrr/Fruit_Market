package com.example.fruitmarket.Fragments.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.fruitmarket.sign_in.Sign_in
import com.example.fruitmarket.R

class Start_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            startActivity(Intent(this, Sign_in::class.java))
        }, 1000)
    }
}