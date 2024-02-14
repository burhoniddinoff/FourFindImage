package com.example.findwordkotlin.presentation.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.fourfindimage_kotlin.R


class MyDialog : DialogFragment() {
    var listener: SelectListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.dialog, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.nextButton).setOnClickListener { v: View? ->
            listener!!.next()
            dismiss()
        }
        view.findViewById<View>(R.id.menuButton).setOnClickListener { v: View? ->
            listener!!.menu()
            dismiss()
        }
    }

    fun setSelectListener(listener: SelectListener?) {
        this.listener = listener
    }
}