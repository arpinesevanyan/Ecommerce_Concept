package com.codeschool.common

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.codeschool.common.network.NetworkLiveData

abstract class BaseCommonActivity : AppCompatActivity() {

    abstract fun noInternetView(): View

    private lateinit var networkLiveData: NetworkLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkLiveData = NetworkLiveData(application)

        networkLiveData.observe(this) { isConnected ->
            if (isConnected) {
                noInternetView().visibility = View.GONE
            } else {
                noInternetView().visibility = View.VISIBLE
            }
        }
    }
}