package com.example.ahxvokabeltrainer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        progressBar = findViewById(R.id.progressBar)

        // Einstellungen
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        // WebViewClient: reagiert auf Seitenwechsel
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
            }
        }

        // Optional: für Fortschritt (z.B. falls du eine Fortschrittsanzeige oben haben willst)
        webView.webChromeClient = WebChromeClient()

        // Startseite aufrufen
        webView.loadUrl("https://vokabeln.familie-herbst.net")
    }

}
