package com.example.fourfindimage_kotlin.presentation.main

import MainContract
import android.content.Context
import com.example.fourfindimage_kotlin.data.model.QuestionData
import com.example.fourfindimage_kotlin.utils.myErrorLog
import com.example.fourfindimage_kotlin.utils.myLog

class MainPresenter(view: MainContract.View) : MainContract.Presenter {

    private var money = 50
    private val max_length: Int = 8
    private var level: Int = 0
    private val answers: ArrayList<String?> = ArrayList()
    private val variants: ArrayList<Boolean> = ArrayList()
    private var hintAnswer: ArrayList<String?> = ArrayList()
    private var view: MainContract.View? = view
    private var model: MainContract.Model? = null

    init {
        this.model =
            MainModel(view as Context)
    }

    override fun clickAnswer(index: Int) {
        view!!.errorAnswerColor(false)
        val clickedAnswer = answers[index]

        if (clickedAnswer == null || clickedAnswer == "") return
        val questionData = model!!.getQuestionById(level)
        val variants: String = questionData!!.variants

        for (i in variants.indices) {
            val currentVariant = variants[i].toString()
            if (clickedAnswer == currentVariant && this.variants[i]) {
                answers[index] = null
                view!!.setAnswer(index, "")
                view!!.setVisibleVariant(i)
                this.variants[i] = false
                return
            }
        }
    }


    override fun clickVariant(index: Int) {
        view!!.errorAnswerColor(false)
        var freeIndex = answers.indexOf(null)
        if (freeIndex == -1) return
        val questionData = model!!.getQuestionById(level)
        answers[freeIndex] = java.lang.String.valueOf(questionData!!.variants[index])
        view!!.setAnswer(
            freeIndex, java.lang.String.valueOf(questionData.variants[index])
        )
        view!!.setInvisibleVariant(index)
        variants[index] = true
        freeIndex = answers.indexOf(null)
        if (freeIndex == -1) check()
    }

    override fun check() {
        val userAnswers = StringBuilder()
        for (answer in answers) {
            if (answer != null) {
                userAnswers.append(answer)
            }
        }

        val questionData = model!!.getQuestionById(level)
        val correctAnswer: String = questionData!!.answer

        if (userAnswers.toString() != correctAnswer) {
            view!!.errorAnswerColor(true)
            return
        }
        money += 30
        view!!.errorAnswerColor(false)
        saveMoney()
        view!!.setMoney(money)
        model!!.setLevel(level + 1)
        view!!.showDialogNext()
    }

    override fun saveMoney() {
        model!!.saveMoney(money)
    }

    override fun onClickKey() {
        if (money < 10) return
        val question: QuestionData? = model!!.getQuestionById(level)
        val indexHint = hintAnswer.indexOf(null)
        val indexAnswer = answers.indexOf(null)
        var index: Int = -1

        if (indexAnswer != -1) {
            for (i in indexAnswer until hintAnswer.size) {
                if (hintAnswer[i] == null) {
                    index = i
                    break
                }
            }

        } else {
            return
        }
        if (index == -1) return
        money -= 10
        view?.setMoney(money)
        "index=>$index".myLog()
        "index=>$question".myLog()
        "${hintAnswer.size}  size".myLog()
        hintAnswer.set(index, (question!!.answer[index].toString()))
        view?.setHintToIndex(index, (question.answer[index].toString()))
    }

    override fun restart() {
        for (i in answers.indices) clickAnswer(i)
    }

    override fun nextLevel() {
        level++
        answers.clear()
        variants.clear()
        view?.clearAnswer()
        setQuestion(false)
    }

    override fun menu() {
        view!!.exit()
    }

    override fun setQuestion(isNew: Boolean) {
        level = model!!.getLevel()
        if (isNew) {
            money = 0;
            model!!.saveMoney(money)
            level = 0
            model!!.setLevel(level)
        }
        if (level > 8) {
            model!!.setLevel(0)
            view!!.startFinish()
            return
        }
//        money = model!!.getMoney()
        view!!.setMoney(money)

        val question: QuestionData? = model!!.getQuestionById(level)
        hintAnswer = ArrayList()
        for (i in 0 until max_length) {
            if (question!!.answer.length <= i) view!!.deleteAnswer(i)
            else {
                answers.add(null)
                hintAnswer.add(null)
            }
        }

        view!!.setLevel(level + 1)
        view!!.setImages(question!!.getImages())
        view!!.setVariants(question.variants)

        for (i in 0 until question.variants.length) variants.add(false)

    }
}