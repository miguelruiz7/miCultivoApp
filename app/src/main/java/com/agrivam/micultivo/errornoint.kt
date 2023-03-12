package com.agrivam.micultivo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class errornoint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_errornoint)
        //Muestra un mensaje donde no hay conexion a internet al cargar la vista
        Toast.makeText(this@errornoint,"No tienes conexion a internet", Toast.LENGTH_LONG).show()


        //Si se presiona el botón reintentar
        val intentarcon = findViewById<Button>(R.id.intentar_con)
        intentarcon.setOnClickListener{
            // Iniciara la actividad principal
            startActivity(Intent(this@errornoint,MainActivity::class.java))
        }


        // Si se presiona el botón salir.
        val salirte = findViewById<Button>(R.id.salir)
        salirte.setOnClickListener{
            // Terminar actividad
            this.finishAffinity()

        }
    }

    //Si presionas el botón de atras te preguntará si deseas salir
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("¿Estas seguro que deseas salir?")
            .setPositiveButton("Si") { _, _ ->
                this.finishAffinity()
            }
            .setNegativeButton("No", null)
            .show()
    }
}