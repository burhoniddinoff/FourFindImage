package com.example.fourfindimage_kotlin.presentation.main

import android.content.Context
import com.example.fourfindimage_kotlin.data.model.QuestionData
import com.example.fourfindimage_kotlin.domain.AppController

class MainModel(context: Context) : MainContract.Model {
    private val appController: AppController

    init {
        appController = AppController.getInstance(context)
    }

    override fun getQuestionById(id: Int): QuestionData? {
        return appController.getQuestionByLevel(id)
    }

    override fun getAnswers(): List<String> {
        return appController.getAnswers()
    }

    override fun getVariants(): List<Boolean> {
        return appController.getVariants()
    }

    override fun getLevel(): Int {
        return appController.getLastLevel()
    }

    override fun setLevel(level: Int) {
        appController.saveLastLevel(level)
    }

    override fun setAnswers(answers: List<String>) {
        appController.saveAnswers(answers)
    }

    override fun setVariants(variants: List<Boolean?>) {
        appController.saveVariants(variants)
    }

    override fun saveMoney(money: Int) {
        appController.saveMoney(money)
    }

    override fun getMoney(): Int {
        return appController.getMoney()
    }
}

