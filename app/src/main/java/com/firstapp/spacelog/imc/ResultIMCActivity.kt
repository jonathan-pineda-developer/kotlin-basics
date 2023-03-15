package com.firstapp.spacelog.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.firstapp.spacelog.R
import com.firstapp.spacelog.imc.imcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0 //se recibe lo que viene de la otra vista
        initComponent()
        initUI(result) // me envia datos a la vista del xml activity basados en los datos que recibio
        initListener()
    }

    private fun initListener() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {

        tvIMC.text = result.toString()

        when (result) {
            in 0.00..18.50 -> { //bajo peso
                tvResult.text = getString(R.string.low_weight) //setiar strings
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.low_weight)) //setiar color
                tvDescription.text = getString(R.string.low_weight_description)
            }
            in 18.51..24.99 -> { //peso ideal
                tvResult.text = getString(R.string.normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.normal_weight)) //setiar color
                tvDescription.text = getString(R.string.nomal_weight_description)
            }
            in 25.00..29.99 -> { //sobre peso
                tvResult.text = getString(R.string.high_weight)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.over_weight)) //setiar color
                tvDescription.text = getString(R.string.high_weight_description)
            }
            in  30.00..99.99 -> { //obsidad
                tvResult.text = getString(R.string.obesity_weight)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesity)) //setiar color
                tvDescription.text = getString(R.string.obesity_weight_description)
            }
            else -> {
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesity))
                tvDescription.text = getString(R.string.error)
            }

        }
    }

    private fun initComponent() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}