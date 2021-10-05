package com.example.calcul

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class Calculator(private val context: MainActivity) {


    fun add(str: String) {
        if (str == "+" || str == "-" || str == "*" || str == "/") {
            val txt = context.textView.text
            if (txt.isNotEmpty() && !txt.contains("+") && !txt.contains("-")
                && !txt.contains("*") && !txt.contains("/")
            ) {
                context.textView.append(str)
            } else {
                Toast.makeText(context, "Некорректный ввод", Toast.LENGTH_SHORT).show()
            }
        } else {
            context.textView.append(str)
        }
    }


    fun clear() {
        context.textView.text = ""
    }

    fun back() {
        if (context.textView.text.isNotEmpty()) {
            val str = context.textView.text.toString()
            if (str.isNotEmpty()) {
                context.textView.text = str.substring(0, str.length - 1)
            }
        }
    }

}