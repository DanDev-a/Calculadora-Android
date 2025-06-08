package com.example.sumapoo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sumapoo.data.Calculadora
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    lateinit var tvR: TextView
    lateinit var tvA: TextView
    val calc = Calculadora()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //View
        tvR = findViewById<TextView>(R.id.tvResultado)
        tvA = findViewById<TextView>(R.id.tvAlm)

        //Numbers
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        //Operators
        val suma = findViewById<Button>(R.id.btnSuma)
        val resta = findViewById<Button>(R.id.btnResta)
        val division = findViewById<Button>(R.id.btnDiv)
        val multiplicacion = findViewById<Button>(R.id.btnMul)

        //Others
        val clean = findViewById<Button>(R.id.btnClean)
        val punto = findViewById<Button>(R.id.btnPoint)
        val operar = findViewById<Button>(R.id.btnIgual)

        //Asign events
        val buttons = listOf<Button>(
            btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, suma, resta, multiplicacion, division, clean,
            punto, operar
        )

        //Recorrer botones
        for(btn in buttons){

            btn.setOnClickListener {
                calc.leerBotones(it , tvR)
                calc.operar(btn, operar, tvA)
            }
            clean.setOnClickListener {
                tvR.text = "0"
            }
            operar.setOnClickListener {
                calc.operar(btn, operar, tvR)
            }

        }
    }
}