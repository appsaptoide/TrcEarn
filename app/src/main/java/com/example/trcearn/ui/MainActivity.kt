package com.example.trcearn.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.trcearn.R
import com.example.webview.mvvm.viewmodal.ViewModal
import com.example.webview.mvvm.viewmodalfactory.ViewModalFactory

class MainActivity : AppCompatActivity() {
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var webView: WebView

    lateinit var viewModal :ViewModal
    @SuppressLint("S\n" +
            "    private lateinit var webView: WebView\n" +
            "    private lateinit var progressBar: ProgressBar\n" +
            "    private lateinietJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        webView = findViewById(R.id.web)
        swipeRefreshLayout = findViewById(R.id.swipe)
        viewModal=ViewModelProvider(this,ViewModalFactory(
            webView,swipeRefreshLayout,this
        )).get(ViewModal::class.java)

        viewModal.web()
    }
}