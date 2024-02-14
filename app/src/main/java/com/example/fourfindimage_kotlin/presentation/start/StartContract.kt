package com.example.fourfindimage_kotlin.presentation.start

interface StartContract {
    interface View {
        fun start(i: Int)
        fun exit()
    }

    interface Presenter {
        fun start()
        fun exit()
        fun newGame()
        fun getMoney(): Int
        fun getLevel(): Int
    }

    interface Model {
        fun getScore(): Int
        fun getLevel(): Int
    }
}