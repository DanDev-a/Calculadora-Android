package com.example.sumapoo.data

import kotlin.math.roundToInt

class Calculadora  {


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