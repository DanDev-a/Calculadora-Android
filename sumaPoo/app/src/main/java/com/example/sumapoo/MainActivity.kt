package com.example.sumapoo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sumapoo.data.Calculadora
import com.google.android.material.textfield.TextInputEditText


class  MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //codigo
        val btn0 = findViewById<Button>(R.id.button0)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)
        val btn5 = findViewById<Button>(R.id.button5)
        val btn6 = findViewById<Button>(R.id.button6)
        val btn7 = findViewById<Button>(R.id.button7)
        val btn8 = findViewById<Button>(R.id.button8)
        val btn9 = findViewById<Button>(R.id.button9)
        val btnPunto = findViewById<Button>(R.id.btnPunto)
        val Limpiar = findViewById<Button>(R.id.btnLimpiar)


        val et1 = findViewById<TextInputEditText>(R.id.et1)
        val et2 = findViewById<TextInputEditText>(R.id.et2)
        val tvR = findViewById<TextView>(R.id.tvResultado)
        val Sumar = findViewById<Button>(R.id.btnSuma)
        val Restar = findViewById<Button>(R.id.btnResta)
        val Multiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val Dividir = findViewById<Button>(R.id.btnDividir)

        val botones = listOf<Button>(
            btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPunto
        )
        // Variable para guardar el último EditText enfocado
        var campoActivo: TextInputEditText? = null

// Cuando un campo gana el foco, lo guardamos como campoActivo
        et1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) campoActivo = et1
        }
        et2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) campoActivo = et2
        }
// Agrega más si tienes más campos...

        for (btn in botones) {
            btn.setOnClickListener {
                if (campoActivo != null) {
                    val actual = campoActivo!!.text.toString()
                    val nuevo = actual + btn.text.toString()
                    campoActivo!!.setText(nuevo)
                    campoActivo!!.setSelection(nuevo.length) // Cursor al final
                } else {
                    Toast.makeText(this, "Toca un campo de texto primero", Toast.LENGTH_SHORT).show()
                }
            }
        }

        Sumar.setOnClickListener{
            //clear code....if
            tvR.text = Calculadora().suma(et1.text.toString(), et2.text.toString())
        }
        Restar.setOnClickListener {
            tvR.text = Calculadora().resta(et1.text.toString(), et2.text.toString())
        }
        Multiplicar.setOnClickListener {
            tvR.text = Calculadora().Multiplicacion(et1.text.toString(), et2.text.toString())
        }
        Dividir.setOnClickListener {
            tvR.text = Calculadora().division(et1.text.toString(), et2.text.toString())
        }
        Limpiar.setOnClickListener {
            tvR.text = "0"
            et1.setText("")
            et2.setText("")
        }
    }
}