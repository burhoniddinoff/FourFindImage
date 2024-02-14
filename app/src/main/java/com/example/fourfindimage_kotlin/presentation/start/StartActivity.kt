package com.example.fourfindimage_kotlin.presentation.start

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.findwordkotlin.presentation.start.StartPresenter
import com.example.fourfindimage_kotlin.R
import com.example.fourfindimage_kotlin.presentation.main.MainActivity

class StartActivity : AppCompatActivity(), StartContract.View {
    private var playButton: AppCompatButton? = null
    private var exitButton: AppCompatButton? = null
    private var newGame: AppCompatButton? = null
    private var presenter: StartContract.Presenter? = null
//    private lateinit var money: TextView
//    private lateinit var level: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        presenter = StartPresenter(this)
        initialize()
    }

    @SuppressLint("SetTextI18n")
    private fun initialize() {
//        money = findViewById(R.id.money)
//        money.text = "Score: ${presenter!!.getMoney()}"
//        level = findViewById(R.id.level)
//        level.text = presenter!!.getLevel().toString()
        playButton = findViewById<View>(R.id.loadButton) as AppCompatButton
        exitButton = findViewById<View>(R.id.exitButton) as AppCompatButton
        newGame = findViewById<View>(R.id.newButton) as AppCompatButton
        newGame!!.setOnClickListener { view: View? -> presenter!!.newGame() }
        playButton!!.setOnClickListener { view: View? -> presenter!!.start() }
        exitButton!!.setOnClickListener { view: View? -> presenter!!.exit() }
    }

    override fun start(i: Int) {
        val intent = Intent(this@StartActivity, MainActivity::class.java)
        if (i == 1) {
            intent.putExtra("game", true)
        }
        startActivity(intent)

    }

    override fun exit() {
        AlertDialog.Builder(this@StartActivity).setMessage("Are you want to exit?")
            .setTitle("Exit?").setPositiveButton(
                "Exit"
            ) { dialog: DialogInterface?, which: Int -> finish() }.setNegativeButton(
                "Cancel"
            ) { dialog: DialogInterface?, which: Int -> }.create().show()
    }

    override fun onResume() {
//        money.text = "Score: ${presenter!!.getMoney()}"
//        level.text = (presenter!!.getLevel() + 1).toString()
        super.onResume()
    }
}