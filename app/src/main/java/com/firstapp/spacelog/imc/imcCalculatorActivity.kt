package com.firstapp.spacelog.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.firstapp.spacelog.R

class imcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewProfile: CardView
    private lateinit var viewSetting: CardView

    private var isOnProfile: Boolean = true
    private var isOnSetting: Boolean = false
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