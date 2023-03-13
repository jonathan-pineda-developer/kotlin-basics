package com.firstapp.spacelog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.firstapp.spacelog.imc.imcCalculatorActivity
import com.firstapp.spacelog.spaceapp.HomeActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnLoginApp = findViewById<Button>(R.id.btnLoginAp)
        val btnCalcApp = findViewById<Button>(R.id.btnCalcApp)
        btnLoginApp.setOnClickListener { navigateToLoginApp() }
        btnCalcApp.setOnClickListener { navegateToImcApp()}
    }

    private fun navegateToImcApp() {
        val intent = Intent(this,imcCalculatorActivity::class.java)
        startActivity(intent)
    }


    private fun navigateToLoginApp(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}