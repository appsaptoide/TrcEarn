package com.example.webview.mvvm.viewmodalfactory

import android.content.Context
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.webview.mvvm.viewmodal.ViewModal

class ViewModalFactory (val webView: WebView,
                        val swipeRefreshLayout: SwipeRefreshLayout,
                        val context: Context
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ViewModal::class.java)) {
            return ViewModal(webView,swipeRefreshLayout,context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}