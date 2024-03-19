package com.example.fourfindimage_kotlin.presentation.start

import android.content.Context
import com.example.fourfindimage_kotlin.domain.AppController
import com.example.fourfindimage_kotlin.presentation.start.StartContract


class StartModel(context: Context) : StartContract.Model{
    private val appController: AppController

    init {
        appController = AppController.getInstance(context)
    }

    override fun getScore(): Int {
        return appController.getMoney()
    }

    override fun getLevel(): Int {
        return appController.getLastLevel()
    }

}

