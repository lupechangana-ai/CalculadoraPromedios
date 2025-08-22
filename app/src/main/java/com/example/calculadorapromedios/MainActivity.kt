package com.example.calculadorapromedios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import kotlin.getValue


import com.example.calculadorapromedios.viewmodel.MainViewModel
class MainActivity : AppCompatActivity() {
    
    private val viewModel: MainViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val num1EditText = findViewById<EditText>(id=R.id.num1EditText)
        val num2EditText = findViewById<EditText>(id=R.id.num2EditText)
        val num3EditText = findViewById<EditText>(id=R.id.num3EditText)
        val calculationButton= findViewById<Button>(id=R.id.calculateButton)
        val resultTextView = findViewById<TextView>(id=R.id.resultTextView)
viewModel.promedio.observe(owner = this, Observe {promedio ->
    resultTextView.text = "Resultado: ${String.formate("%.2f", promedio)}"
})

viewModel.guardarMensaje.observe(owner = this, Observer {message ->
    Toast.makeText(context = this, text = message, duration = Toast.LENGTH_SHORT).show()
})

calculationButton.setOnClickListener {
    try{
        val n1 = num1EditText.text.toString().toDouble()
        val n2 = num1EditText.text.toString().toDouble()
        val n3 = num1EditText.text.toString().toDouble()
        
        viewModel.calcularPromedio(n1, n2, n3)
    } catch (e: Exception){
        Toast.makeText(context = this, text = "Ingrese valores válidos", Toast.LENGTH_SHORT).show()
    }
        }
    }
}