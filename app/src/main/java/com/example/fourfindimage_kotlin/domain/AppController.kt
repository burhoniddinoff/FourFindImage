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
            0 ->
//                QuestionData(
//                "pear",
//                "aslwvedzrfvp",
//                R.drawable.lg_nok_1,
//                R.drawable.lg_nok_2,
//                R.drawable.lg_nok_3,
//                R.drawable.lg_nok_4
//            )

                QuestionData(
                    "network",
                    "fknaarqowzet",
                    R.drawable.net1,
                    R.drawable.net2,
                    R.drawable.net3,
                    R.drawable.net4
                )

            1 ->
//            QuestionData(
//                "kiwi",
//                "awkasfcizfci",
//                R.drawable.kiwi_1,
//                R.drawable.kiwi_2,
//                R.drawable.kiwi_3,
//                R.drawable.kiwi_4
//            )

                QuestionData(
                    "sky",
                    "yawsdfzdkqla",
                    R.drawable.sky1,
                    R.drawable.sky2,
                    R.drawable.sky3,
                    R.drawable.sky4
                )


            2 ->
//                QuestionData(
//                "peach",
//                "hecapacofrhd",
//                R.drawable.lg_shaftoli_1,
//                R.drawable.lg_shaftoli_2,
//                R.drawable.lg_shaftoli_3,
//                R.drawable.lg_shaftoli_4
//            )
                QuestionData(
                    "river",
                    "araarezkizvq",
                    R.drawable.rive1,
                    R.drawable.rive2,
                    R.drawable.rive3,
                    R.drawable.rive4
                )

            3 ->
//                QuestionData(
//                "apple",
//                "asdjgpaspewl",
//                R.drawable.lg_olma_1,
//                R.drawable.lg_olma_2,
//                R.drawable.lg_olma_3,
//                R.drawable.lg_olma_4
//            )
                QuestionData(
                    "letter",
                    "resldqtdedzt",
                    R.drawable.letter1,
                    R.drawable.letter2,
                    R.drawable.letter3,
                    R.drawable.letter4,
                )

            4 ->
//                QuestionData(
//                "banana",
//                "qabnewnaqoza",
//                R.drawable.lg_banan_1,
//                R.drawable.lg_banan_2,
//                R.drawable.lg_banan_3,
//                R.drawable.lg_banan_4
//            )
                QuestionData("book", "kkabsdowswsk",R.drawable.library1, R.drawable.library2, R.drawable.library3, R.drawable.library4)

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