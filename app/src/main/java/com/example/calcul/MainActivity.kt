package com.example.calcul

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calc = Calculator(this)

        zero.setOnClickListener { calc.add("0") }
        one.setOnClickListener { calc.add("1") }
        two.setOnClickListener { calc.add("2") }
        three.setOnClickListener { calc.add("3") }
        four.setOnClickListener { calc.add("4") }
        five.setOnClickListener { calc.add("5") }
        six.setOnClickListener { calc.add("6") }
        seven.setOnClickListener { calc.add("7") }
        eight.setOnClickListener { calc.add("8") }
        nine.setOnClickListener { calc.add("9") }

        plus.setOnClickListener { calc.add("+") }
        minus.setOnClickListener { calc.add("-") }
        multiply.setOnClickListener { calc.add("*") }
        delete.setOnClickListener { calc.add("/") }
        dot.setOnClickListener { calc.add(".") }

        back.setOnClickListener { calc.back() }
        c.setOnClickListener { calc.clear() }
    }
}