package com.agrivam.micultivo

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Servicio de conectividad web
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
        val networkInfo = connectivityManager.activeNetwork;
        val capabilities = connectivityManager.getNetworkCapabilities(networkInfo)
        //Creamos un webview
        val webView = findViewById<WebView>(R.id.webView)

        var url = "https://micultivov4.000webhostapp.com"

        //Verificamos si cumple con la conectividad
        if (capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || capabilities.hasTransport(
                NetworkCapabilities.TRANSPORT_CELLULAR) && (URLUtil.isValidUrl(url)))
        ) {
            // Se abre el vieweb
            webView.webViewClient = object : WebViewClient() {
                //Si hay un error nos dirige a una plantilla para obligar a que verifique su conexion a red
                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    //Inicia la actividad donde se aloja el error
                    super.onReceivedError(view, request, error)
                    startActivity(Intent(this@MainActivity, errornoint::class.java))

                }
            }
            //Habilita el JS
            webView.settings.javaScriptEnabled = true;
            //Carga nuestro JS
            webView.loadUrl("https://micultivov4.000webhostapp.com");
        } else {
            startActivity(Intent(this@MainActivity, errornoint::class.java))
        }
    }

    //Presionamos el botón de atras nos dara un cuadro de dialogo que si queremos salir
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