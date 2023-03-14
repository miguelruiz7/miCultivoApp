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
        Toast.makeText(this@errornoint,"Verifica que los datos ó WIFI esten activos y dispongas de red", Toast.LENGTH_LONG).show()

        //Carga un reintento

        AlertDialog.Builder(this@errornoint)
            .setMessage("No dispones conexión a red ¿Deseas reintentarlo?")
            .setPositiveButton("Si") { _, _ ->
                startActivity(Intent(this@errornoint,MainActivity::class.java))
            }
            .setNegativeButton("Salir"){_,_ ->
                finishAffinity()
            }
            .setCancelable(false)
            .show()

            .setCanceledOnTouchOutside(false)
    }



    //Si presionas el botón de atras te preguntará si deseas salir
    override fun onBackPressed() {

    }
}