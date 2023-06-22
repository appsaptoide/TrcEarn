package com.example.webview.mvvm.viewmodal

import android.content.Context
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.webview.mvvm.repository.Repository
import kotlinx.coroutines.launch


class ViewModal (  val webView: WebView,val swipeRefreshLayout: SwipeRefreshLayout,
                                      val context: Context):ViewModel() {
           private val repository by lazy {
               Repository(webView, swipeRefreshLayout, context
           ) }
    fun web(){
        viewModelScope.launch {
            repository.webView()
        }
    }

}