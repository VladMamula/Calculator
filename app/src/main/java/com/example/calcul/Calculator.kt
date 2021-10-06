package com.example.calcul


import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt


class Calculator(private val context: MainActivity) {


    fun add(str: String) {  // функия добавления символа в строку
        val string = context.textView.text
        // Чтобы нельзя было ввести операцию в пустую строку
        if (string.isEmpty() && (str == "+" || str == "*" || str == "/" || str == "-")) {
            return
        }
        // Чтобы нельзя было использовать операции несколько раз (с учетом того, что минус может встречаться при отрицательном числе)
        if (string.isNotEmpty() && (str == "+" || str == "*" || str == "/" || str == "-") &&
            (string.contains("+") || string.contains("*") || string.contains("/") || (string.contains("-")
                    && string[0] != '-'))
        ) {
            return
        }
        context.textView.append(str)
    }

    fun sqrt() { // функция выводящая корень из числа
        val str = context.textView.text.toString()
        // Строка не пустая и не содержит мат. операции
        if (str.isNotEmpty() && !str.contains("+") && !str.contains("-") && !str.contains("*") && !str.contains("/"))
            context.textView.text = sqrt(str.toDouble()).toString()
    }

    fun clear() { // функция очистки поля
        context.textView.text = ""
    }

    fun invert() { // функция инвертация числа
        val str = context.textView.text
        // Строка не пустая и не содержит мат. операции
        if (str.isNotEmpty() && !str.contains("+")
            && !str.contains("*") && !str.contains("/") && (!str.contains("-") || str[0] == '-')
        )
            context.textView.text = (str.toString().toDouble() * (-1)).toString()
    }


    fun back() { // функция удаления последнего символа из строки
        if (context.textView.text.isNotEmpty()) { // если строчка не пустая
            val str = context.textView.text.toString()
            context.textView.text = context.textView.text.substring(0, str.length - 1)
        }
    }


    private fun calculate(num1: Double, num2: Double, operation: String) { // функция, выводящая ответ в текстовое поле
        // Проверяем какая операция была подана на вход
        if (operation == "minus")
            context.textView.text = (num1 - num2).toString()
        else if (operation == "plus")
            context.textView.text = (num1 + num2).toString()
        else if (operation == "mult")
            context.textView.text = (num1 * num2).toString()
        else context.textView.text = (num1 / num2).toString()
    }

    fun result() { // функция передающая первое число, второе число и операцию в функцию calculate
        val str = context.textView.text

        if (str.contains("+")) { // если строка содержит плюс
            if (str[0] != '-') { // и первое число не отрицательное
                val first = context.textView.text.toString().substringBefore('+') // находим первое число
                val second = context.textView.text.toString().substringAfter('+') // находим второе число
                calculate(first.toDouble(), second.toDouble(), "plus") // передаем в функцию
            } else {
                val first = str.toString().substringAfter('-')
                    .substringBefore('+')
                val second = str.toString().substringAfter('+')
                calculate("-$first".toDouble(), second.toDouble(), "plus")
                return
            }
        }

        if (str.contains("*")) {  // если строка содержит знак умножения
            if (str[0] != '-') {  // и первое число не отрицательное
                val first = context.textView.text.toString().substringBefore('*')
                val second = context.textView.text.toString().substringAfter('*')
                calculate(first.toDouble(), second.toDouble(), "mult")
            } else {
                val first = str.toString().substringAfter('-')
                    .substringBefore('*')
                val second = str.toString().substringAfter('*')
                calculate("-$first".toDouble(), second.toDouble(), "mult")
                return
            }

        }
        if (str.contains("/")) { // если строка содержит знак деления
            if (str[0] != '-') {  // и первое число не отрицательное
                val first = context.textView.text.toString().substringBefore('/')
                val second = context.textView.text.toString().substringAfter('/')
                calculate(first.toDouble(), second.toDouble(), "div")
            } else {
                val first = str.toString().substringAfter('-')
                    .substringBefore('/')
                val second = str.toString().substringAfter('/')
                calculate("-$first".toDouble(), second.toDouble(), "div")
                return
            }
        }

        if (str.contains("-")) { // если строка содержит минус
            if (str[0] != '-') {  // и первое число не отрицательное
                val first = str.toString().substringBefore('-')
                val second = str.toString().substringAfter('-')
                calculate(first.toDouble(), second.toDouble(), "minus")
            } else {
                val first = str.toString().substringAfter('-')
                    .substringBefore('-')
                val second = str.toString().substringAfter('-')
                    .substringAfter('-')
                calculate("-$first".toDouble(), second.toDouble(), "minus")
                return
            }
        }
    }

}