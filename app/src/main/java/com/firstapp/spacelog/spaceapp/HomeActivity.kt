package com.firstapp.spacelog.spaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.firstapp.spacelog.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnlogin = findViewById<AppCompatButton>(R.id.btnlogin)
        btnlogin.setOnClickListener{
            Log.i("Welcome","NewCitizen")
        }
    }
}