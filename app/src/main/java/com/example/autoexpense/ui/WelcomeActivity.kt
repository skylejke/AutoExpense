package com.example.autoexpense.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.autoexpense.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val thread = object : Thread() {
            override fun run() {
                try {
                    sleep(1500)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
        thread.start()
    }
}