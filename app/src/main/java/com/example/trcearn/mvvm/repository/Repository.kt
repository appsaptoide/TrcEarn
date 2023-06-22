package com.example.webview.mvvm.repository

import android.content.Context
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Handler
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.webview.utils.Constants

class Repository(val webView: WebView,
                 val swipeRefreshLayout: SwipeRefreshLayout,
                 val context: Context ) {

    suspend fun webView(){
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(false)
        webView.settings.domStorageEnabled = true
        webView.webViewClient = MyWebViewClient()
        webView.loadUrl(Constants.BASE_URL)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            Handler().postDelayed({
                swipeRefreshLayout.isRefreshing = false
                webView.loadUrl(Constants.BASE_URL)
            }, 3000)
        }
        swipeRefreshLayout.setColorSchemeColors(
            context.resources.getColor(android.R.color.holo_blue_bright),
            context.resources.getColor(android.R.color.holo_orange_dark),
            context.resources.getColor(android.R.color.holo_green_dark),
            context.resources.getColor(android.R.color.holo_red_dark)
        )
    }

    inner class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {

        }

        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            super.onReceivedSslError(view, handler, error)
            handler.cancel()
        }

        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)

        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)

        }
    }
}