package com.example.caculator

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val values = IntArray(2){0}
    var sign:String = ""
    var v_id:Int = 0
    val states = arrayOf(
        intArrayOf(android.R.attr.state_pressed),  // pressed
        intArrayOf(android.R.attr.state_enabled)  // enable
    )
    val numBtnColors = intArrayOf(
        Color.RED,
        Color.LTGRAY
    )
    val otherBtnColors = intArrayOf(
        Color.RED,
        Color.GRAY
    )
    val numBtnStateList = ColorStateList(states, numBtnColors)
    val otherBtnStateList = ColorStateList(states, otherBtnColors)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBnt()
        screenPanelDisplay()
    }

    private fun setBnt() {
        for (i in 0..9){
            val idString = "_$i"
            val buttonID = resources.getIdentifier(idString, "id", packageName)
            val button: Button = findViewById(buttonID)
            button.setBackgroundTintList(numBtnStateList)
            button.setOnClickListener{
                values[v_id] = values[v_id] * 10 + i
                screenPanelDisplay()
            }
        }

        var button: Button = findViewById(R.id.CE)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
            values[v_id] = 0
            screenPanelDisplay()
        }

        button = findViewById(R.id.C)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
            values[0] = 0
            values[1] = 0
            v_id = 0
            screenPanelDisplay()
        }

        button = findViewById(R.id.BS)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
            values[v_id] = values[v_id] / 10
            screenPanelDisplay()
        }

        button = findViewById(R.id.plus)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
            println("PLUS")
            if (v_id == 0) {
                v_id = 1
                sign = "plus"
            } else {
                v_id = 0
                cal()
            }
            screenPanelDisplay()
        }

        button = findViewById(R.id.minus)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
            if (v_id == 0) {
                v_id = 1
                sign = "minus"
            } else {
                v_id = 0
                cal()
            }
            screenPanelDisplay()
        }

        button = findViewById(R.id.multiply)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
            if (v_id == 0) {
                v_id = 1
                sign = "multiply"
            } else {
                v_id = 0
                cal()
            }
            screenPanelDisplay()
        }

        button = findViewById(R.id.divide)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
            if (v_id == 0) {
                v_id = 1
                sign = "divide"
            } else {
                v_id = 0
                cal()
            }
            screenPanelDisplay()
        }

        button = findViewById(R.id.equal)
        button.setBackgroundTintList(otherBtnStateList)
        button.setOnClickListener {
             if (v_id == 1) {
                v_id = 0
                cal()
            }
            screenPanelDisplay()
        }

        button = findViewById(R.id.smth1)
        button.setBackgroundTintList(otherBtnStateList)

        button = findViewById(R.id.dot)
        button.setBackgroundTintList(otherBtnStateList)
    }

    fun cal() {
        if (sign == "plus") {
            values[0] = values[0] + values[1]
        }
        if (sign == "minus") {
            values[0] = values[0] - values[1]
        }
        if (sign == "multiply") {
            values[0] = values[0] * values[1]
        }
        if (sign == "divide") {
            values[0] = values[0] / values[1]
        }
        values[1] = 0
    }

    fun screenPanelDisplay(){
        val screenPanel: TextView = findViewById(R.id.screenPanel)
        screenPanel.text = values[v_id].toString()
    }
}