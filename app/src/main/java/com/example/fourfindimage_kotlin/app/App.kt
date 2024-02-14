package com.example.fourfindimage_kotlin.app

import android.app.Application
import com.example.fourfindimage_kotlin.domain.AppController

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppController.getInstance(this)
    }
}