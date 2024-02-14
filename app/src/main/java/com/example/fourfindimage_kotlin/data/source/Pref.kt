package com.example.fourfindimage_kotlin.data.source

import android.content.Context
import android.content.SharedPreferences

class Pref private constructor(context: Context) {
    private val pref: SharedPreferences

    init {
        pref = context.getSharedPreferences("MyGame", Context.MODE_PRIVATE)
    }

    companion object {
        private var instance: Pref? = null

        fun getInstance(context: Context): Pref {
            if (instance == null) {
                instance = Pref(context)
            }
            return instance!!
        }
    }

    fun saveMoney(money: Int) = pref.edit().putInt("MONEY", money).apply()
    fun getMoney(): Int = pref.getInt("MONEY", 0)
    fun saveAnswers(answers: List<String>) {
        var sb: StringBuilder = StringBuilder()
        for (answer: String in answers) {
            if (answer.isEmpty()) {
                sb.append("*")
            } else {
                sb.append(answer)
            }
        }

        pref.edit().putString("ANSWERS", sb.toString())
    }

    fun getAnswers(): List<String> {
        val answer: String? = pref.getString("ANSWERS", "********")
        var res: ArrayList<String> = ArrayList<String>()
        for (i in 0 until answer!!.length){
            if (answer[i]=='*'){
                res.add("")
            }else{
                res.add(answer[i].toString())
            }
        }
        return res
    }
    fun saveVariants(variants: List<Boolean?>) {
        val sb = java.lang.StringBuilder()
        for (variant in variants) {
            if (variant == true) {
                sb.append("1")
            } else {
                sb.append("0")
            }
        }
        pref.edit().putString("BUTTONS_VARIANTS", sb.toString()).apply()
    }
    fun getVariants():List<Boolean>{
        val variant = pref.getString("BUTTONS_VARIANTS", "000000000000")
        var res: ArrayList<Boolean> = ArrayList<Boolean>()
        for (i in 0 until variant!!.length){
            if (variant[i]=='1')res.add(true)
            else res.add(false)
        }
        return res
    }
    fun saveLastLevel(level: Int) =pref.edit().putInt("LEVEL",level).apply()
    fun getLastLevel():Int = pref.getInt("LEVEL",0)
}
