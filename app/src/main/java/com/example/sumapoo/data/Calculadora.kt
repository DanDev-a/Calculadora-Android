package com.example.sumapoo.data

import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToInt

class Calculadora  {

    fun leerBotones(view: View, tv: TextView){
        var btn = view as Button
        var concat = if (tv.text.toString() == "0") btn.text.toString() else tv.text.toString() + btn.text.toString()
        tv.text = concat
    }

    fun operar(button: Button, igual: Button, tv: TextView){
        var operador: String? = null
        if(button == igual){
            operador = when{
                tv.text.toString().contains("+") -> "+"
                tv.text.toString().contains("-") -> "-"
                tv.text.toString().contains("*") -> "*"
                tv.text.toString().contains("/") -> "/"
                else -> null
            }
        }
        separar(operador, tv)
    }
    fun separar(operador: String?,tv: TextView){
        if (operador != null){
            val partes = tv.text.toString().split(operador)
            if (partes.size == 2) {
                val a = partes[0].trim()
                val b = partes[1].trim()
                val resultado = when (operador) {
                    "+" -> suma(a, b)
                    "-" -> resta(a, b)
                    "*" -> Multiplicacion(a, b)
                    "/" -> division(a, b)
                    else -> "Error"
                }
                tv.text = resultado
            }
        }
    }

    fun suma(a: String, b:String):String{
        val total = a.toFloat() + b.toFloat()
        val redon = (total * 100.0).roundToInt() / 100.0
        val data = validarEnteroDecimal(redon.toString())
        return data
    }

    fun resta(a: String, b:String):String{
        val total = a.toFloat() - b.toFloat()
        val redon = (total * 100.0).roundToInt() / 100.0
        val data = validarEnteroDecimal(redon.toString())
        return data
    }

    fun Multiplicacion(a: String, b:String):String{
        val total = a.toFloat() * b.toFloat()
        val redon = (total * 100.0).roundToInt() / 100.0
        val data = validarEnteroDecimal(redon.toString())
        return data
    }

    fun division(a: String, b:String):String{
        if (b.toFloat() != 0.0f){
            val total = a.toFloat() / b.toFloat()
            val redon = (total * 100.0).roundToInt() / 100.0
            val data = validarEnteroDecimal(redon.toString())
            return data
        }
        return "Error..."

    }

    private fun validarEnteroDecimal(t:String):String{
        val num = t.toFloat()
        return if (num % 1.0f == 0.0f)  num.toInt().toString() else num.toString()
    }

    




}

