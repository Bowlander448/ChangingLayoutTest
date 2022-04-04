package com.example.changinglayouttest

import android.appwidget.AppWidgetHost
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    private lateinit var widthWidget: EditText
    private lateinit var  heightWidget: EditText
    private lateinit var  resultWidget: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        widthWidget = findViewById(R.id.widthText)
        heightWidget = findViewById(R.id.heightText)
        resultWidget = findViewById(R.id.resultText)

        widthWidget.doAfterTextChanged {
            calculateArea()
        }

        heightWidget.doAfterTextChanged {
            calculateArea()
        }

    }

    fun calculateArea(){
        val width = widthWidget.text.toString().toDoubleOrNull()
        val height = heightWidget.text.toString().toDoubleOrNull()

        Log.i("AreaApp", "width is $width, height is $height")

        if (width == null || height == null) {
            return
        }

        val area = width * height

        val message ="Result is"
        val displayMessage = "$message $area"

        resultWidget.text = displayMessage
    }
}