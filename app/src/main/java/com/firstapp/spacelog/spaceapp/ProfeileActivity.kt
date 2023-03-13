package com.firstapp.spacelog.spaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.firstapp.spacelog.R

class ProfeileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profeile)
        val yourName = findViewById<TextView>(R.id.yourName)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        yourName.text = "Welcome "+ name
    }
}