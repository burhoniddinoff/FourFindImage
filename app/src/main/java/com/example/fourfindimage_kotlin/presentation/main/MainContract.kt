import com.example.fourfindimage_kotlin.data.model.QuestionData

interface MainContract {
    interface Model {
        fun getQuestionById(id: Int): QuestionData?
        fun getAnswers(): List<String>
        fun getVariants(): List<Boolean?>
        fun getLevel(): Int
        fun setLevel(level: Int)
        fun setAnswers(answers: List<String>)
        fun setVariants(variants: List<Boolean?>)
        fun saveMoney(money: Int)
        fun getMoney(): Int
    }

    interface View {
        fun startFinish()
        fun showDialogNext()
        fun setImages(images: List<Int>)
        fun clearAnswer()
        fun setLevel(level: Int)
        fun setVariants(variants: String)
        fun setVisibleVariant(index: Int)
        fun setInvisibleVariant(index: Int)
        fun setAnswer(index: Int, answer: String?)
        fun deleteAnswer(index: Int)
        fun showResult(s: String?)
        fun exit()
        fun setMoney(money: Int)
    }

    interface Presenter {
        fun restart()
        fun nextLevel()
        fun menu()
        fun setQuestion(newOrLoad: Boolean)
        fun clickAnswer(index: Int)
        fun clickVariant(index: Int)
        fun check()
        fun saveMoney()
    }
}
