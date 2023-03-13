package com.firstapp.spacelog.spaceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.firstapp.spacelog.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnlogin = findViewById<AppCompatButton>(R.id.btnlogin)
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        btnlogin.setOnClickListener {
            val name = etName.text.toString()

            if (name.isNotEmpty()){
                val intent = Intent(this, ProfeileActivity::class.java)
                intent.putExtra("EXTRA_NAME",name)
                startActivity(intent)
            }


        }
    }
}