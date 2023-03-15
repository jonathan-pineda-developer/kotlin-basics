package com.firstapp.spacelog.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.firstapp.spacelog.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class imcCalculatorActivity : AppCompatActivity() {

    private var currentWeight: Int = 50
    private var currentAge: Int = 18
    private var currentHeight: Int = 120

    private lateinit var viewProfile: CardView
    private lateinit var viewSetting: CardView

    private var isOnProfile: Boolean = true
    private var isOnSetting: Boolean = false

    private lateinit var viewHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var viewPeso: TextView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton

    private lateinit var viewEdad: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton

    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponent()
        initListener()
        initUI()
    }


    private fun initComponent() {
        viewProfile = findViewById(R.id.viewProfile)
        viewSetting = findViewById(R.id.viewSetting)
        viewHeight = findViewById(R.id.viewHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        viewPeso = findViewById(R.id.viewPeso)
        viewEdad = findViewById(R.id.viewEdad)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnCalculate = findViewById(R.id.btnCalculate)

    }

    private fun initListener() {
        viewProfile.setOnClickListener {
            changeColor()
            isClick()
        }
        viewSetting.setOnClickListener {
            changeColor()
            isClick()
        }
        rsHeight.addOnChangeListener { _, value, _ ->

            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()

            viewHeight.text = "$currentHeight  CM"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
            //esta funcion en el boton me envia a la vista el valor del imc
        }

    }

    private fun navigateToResult(result: Double) {
        val inten = Intent(this, ResultIMCActivity::class.java) //navegue a la clase resultImcactivi
        inten.putExtra(IMC_KEY,result) //agreguele el valor
        startActivity(inten) //inicie la vista
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(imc).toDouble()
//        Log.i("arist","el imc es $result")
    }

    private fun setWeight() {
        viewPeso.text = currentWeight.toString()
    }

    private fun setAge() {
        viewEdad.text = currentAge.toString()
    }

    private fun isClick() {


        viewProfile.setBackgroundColor(getBackgroundColor(isOnProfile))
        viewSetting.setBackgroundColor(getBackgroundColor(isOnSetting))

    }

    private fun changeColor() {
        isOnProfile = !isOnProfile
        isOnSetting = !isOnSetting
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {


        val referenceColor = if (isSelectedComponent) {
            R.color.background_content_selected
        } else {
            R.color.background_content

        }
        return ContextCompat.getColor(this, referenceColor)
    }

    private fun initUI() {
        isClick()
        setWeight()
        setAge()
    }
}