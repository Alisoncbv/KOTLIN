package com.alisoncbv.myapplicatio
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class Producto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val atras = findViewById<Button>(R.id.buttonAtras)

        //Redirecionar a otra vista
        atras.setOnClickListener {
            val vista=Intent(this, MainActivity::class.java)
            startActivity(vista)
        }
    }
}