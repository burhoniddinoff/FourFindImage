package com.example.fourfindimage_kotlin.presentation.start

import android.content.Context
import com.example.fourfindimage_kotlin.presentation.start.StartContract
import com.example.fourfindimage_kotlin.presentation.start.StartModel

class StartPresenter(private val view: StartContract.View) : StartContract.Presenter {
    private val model: StartContract.Model

    init {
        model = StartModel(view as Context)
    }

    override fun start() {
        view.start(0)
    }

    override fun exit() {
        view.exit()
    }

    override fun newGame() {
        view.start(1)
    }

    override fun getMoney(): Int {
        return model.getScore()
    }

    override fun getLevel(): Int {
        return model.getLevel()
    }
}
