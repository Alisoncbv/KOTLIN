package com.alisoncbv.myapplicatio
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val codigo = findViewById<EditText>(R.id.editTextNumberSignedCodigo)
        val nombre = findViewById<EditText>(R.id.editTextTextNombre)
        val precio = findViewById<EditText>(R.id.editTextNumberSignedPrecio)
        val registrar = findViewById<Button>(R.id.buttonRegistrar)
        val consultar = findViewById<Button>(R.id.buttonConsultar)
        val editar = findViewById<Button>(R.id.buttonEditar)
        val eliminar = findViewById<Button>(R.id.buttonEliminar)

        //Función registrar
        registrar.setOnClickListener {
            val adminBD = AdminSQL(this, "AlisonBD", null, 1)
            val bd = adminBD.writableDatabase

            val consulta = bd.rawQuery(
                "select codigo from producto where codigo = ${codigo.text.toString().toInt()}", null
            )

            if (consulta.moveToFirst()) {
                Toast.makeText(this, "Codigo ya registrado", Toast.LENGTH_LONG).show()
            } else {
                val registro = ContentValues()
                registro.put("codigo", codigo.text.toString().toInt())
                registro.put("nombre", nombre.text.toString())
                registro.put("precio", precio.text.toString().toInt())

                bd.insert("producto", null, registro)
            }

            bd.close()

            codigo.setText("")
            nombre.setText("")
            precio.setText("")

            Toast.makeText(this, "¡Producto registrado correctamente!", Toast.LENGTH_LONG).show()

        }

        //Función consultar
        consultar.setOnClickListener {
            val adminBD = AdminSQL(this, "AlisonBD", null, 1)
            val bd = adminBD.writableDatabase
            val consulta = bd.rawQuery(
                "select nombre, precio from producto where codigo = ${codigo.text.toString().toInt()}", null
            )

            if (consulta.moveToFirst()) {
                nombre.setText(consulta.getString(0))
                precio.setText(consulta.getString(1))
            } else {
                codigo.setText("")
                nombre.setText("")
                precio.setText("")
                Toast.makeText(this, "¡Producto no encontrado!", Toast.LENGTH_LONG).show()
            }
            bd.close()
        }

        //Función editar
        editar.setOnClickListener {
            val adminBD = AdminSQL(this, "AlisonBD", null, 1)
            val bd = adminBD.writableDatabase

            val registro = ContentValues()

            registro.put("nombre", nombre.text.toString())
            registro.put("precio", precio.text.toString().toInt())

            val editar = bd.update("producto", registro, "codigo=${codigo.text.toString()}", null)
            bd.close()

            if (editar == 1) {
                Toast.makeText(this, "¡Producto actualizado correctamente!", Toast.LENGTH_LONG).show()
                codigo.setText("")
                nombre.setText("")
                precio.setText("")

            } else {
                Toast.makeText(this, "¡Producto no encontrado!", Toast.LENGTH_LONG).show()
            }
        }

        //Función eliminar
        eliminar.setOnClickListener {
            val adminBD = AdminSQL(this, "AlisonBD", null, 1)
            val bd = adminBD.writableDatabase

            val eliminar =
                bd.delete("producto", "codigo = ${codigo.text.toString().toInt()}", null)
            bd.close()
            codigo.setText("")
            nombre.setText("")
            precio.setText("")

            if (eliminar == 1) {
                Toast.makeText(this, "¡Producto eliminado correctamente!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "¡El producto no existia!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
