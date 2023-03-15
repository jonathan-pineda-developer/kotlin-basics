package com.firstapp.spacelog.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.firstapp.spacelog.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class imcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewProfile: CardView
    private lateinit var viewSetting: CardView

    private var isOnProfile: Boolean = true
    private var isOnSetting: Boolean = false

    private lateinit var viewHeight: TextView
    private lateinit var rsHight: RangeSlider

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
        rsHight = findViewById(R.id.rsHeight)

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
        rsHight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)

            viewHeight.text = result + " CM"
        }
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
    }
}