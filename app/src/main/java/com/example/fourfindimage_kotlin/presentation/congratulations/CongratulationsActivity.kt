package com.example.fourfindimage_kotlin.presentation.congratulations

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fourfindimage_kotlin.R
import com.example.fourfindimage_kotlin.domain.AppController

class CongratulationsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulations)

        findViewById<View>(R.id.menu).setOnClickListener { menu() }
    }

    private fun menu() {
        val appController: AppController = AppController.getInstance(this as Context)
        appController.saveLastLevel(0)
        appController.saveMoney(0)
        finish()
    }
}