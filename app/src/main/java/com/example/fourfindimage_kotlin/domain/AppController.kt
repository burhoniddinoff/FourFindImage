package com.example.fourfindimage_kotlin.domain

import android.content.Context
import com.example.fourfindimage_kotlin.R
import com.example.fourfindimage_kotlin.data.model.QuestionData
import com.example.fourfindimage_kotlin.data.source.Pref

class AppController private constructor() {
    companion object {
        lateinit var pref: Pref

        @Volatile
        private var instance: AppController? = null;
        fun getInstance(context: Context): AppController {
            if (instance == null) {
                synchronized(this) {
                    instance = AppController()
                }
            }
            pref = Pref.getInstance(context)
            return instance!!
        }
    }

    fun saveMoney(score: Int) = pref.saveMoney(score)
    fun getMoney(): Int = pref.getMoney()
    fun saveAnswers(answers: List<String>) = pref.saveAnswers(answers)
    fun getAnswers(): List<String> = pref.getAnswers()
    fun saveVariants(variants: List<Boolean?>) = pref.saveVariants(variants)
    fun getVariants(): List<Boolean> = pref.getVariants()
    fun saveLastLevel(level: Int) = pref.saveLastLevel(level)
    fun getLastLevel(): Int = pref.getLastLevel()

    fun getQuestionByLevel(level: Int): QuestionData? {
        return when (level) {
            0 -> QuestionData(
                "pear",
                "aslwvedzrfvp",
                R.drawable.lg_nok_1,
                R.drawable.lg_nok_2,
                R.drawable.lg_nok_3,
                R.drawable.lg_nok_4
            )

            1 -> QuestionData(
                "kiwi",
                "awkasfcizfci",
                R.drawable.kiwi_1,
                R.drawable.kiwi_2,
                R.drawable.kiwi_3,
                R.drawable.kiwi_4
            )

            2 -> QuestionData(
                "peach",
                "hecapacofrhd",
                R.drawable.lg_shaftoli_1,
                R.drawable.lg_shaftoli_2,
                R.drawable.lg_shaftoli_3,
                R.drawable.lg_shaftoli_4
            )

            3 -> QuestionData(
                "apple",
                "asdjgpaspewl",
                R.drawable.lg_olma_1,
                R.drawable.lg_olma_2,
                R.drawable.lg_olma_3,
                R.drawable.lg_olma_4
            )

            4 -> QuestionData(
                "banana",
                "qabnewnaqoza",
                R.drawable.lg_banan_1,
                R.drawable.lg_banan_2,
                R.drawable.lg_banan_3,
                R.drawable.lg_banan_4
            )

            5 -> QuestionData(
                "lemon",
                "welsefodmasn",
                R.drawable.lemon_1,
                R.drawable.lemon_2,
                R.drawable.lemon_3,
                R.drawable.lemon_4
            )

            6 -> QuestionData(
                "cherry",
                "qyascroarhep",
                R.drawable.lg_cherry_1,
                R.drawable.lg_cherry_2,
                R.drawable.lg_cherry_3,
                R.drawable.lg_cherry_4
            )

            7 -> QuestionData(
                "quince",
                "apeilrnaqcau",
                R.drawable.lg_quince_1,
                R.drawable.lg_quince_2,
                R.drawable.lg_quince_3,
                R.drawable.lg_quince_4
            )

            8 -> QuestionData(
                "grapes",
                "apfzqgmvrsve",
                R.drawable.lg_grapes_1,
                R.drawable.lg_grapes_2,
                R.drawable.lg_grapes_3,
                R.drawable.lg_grapes_4
            )

            // mandarin
//                return new QuestionData("mandarin", "pyoquraliufn", R.drawable.qulupnay_1, R.drawable.qulupnay_2, R.drawable.qulupnay_3, R.drawable.qulupnay_4);

            else -> null

        }
    }
}