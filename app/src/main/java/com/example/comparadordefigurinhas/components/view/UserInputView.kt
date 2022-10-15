package com.example.comparadordefigurinhas.components.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.comparadordefigurinhas.R
import com.example.comparadordefigurinhas.databinding.ViewUserInputBinding
import com.example.comparadordefigurinhas.model.User

class UserInputView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding =
        ViewUserInputBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    private val userTitleView by lazy { binding.userTitle }
    private val repeatView by lazy { binding.repeat }
    private val missingView by lazy { binding.missing }

    init {
        obtainStyleAttributes()
    }

    private fun obtainStyleAttributes() {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.UserInputView,
            0,
            0
        ).apply {
            try {
                val title = getString(R.styleable.UserInputView_userTitle)
                userTitleView.text = title
            } finally {
                recycle()
            }
        }
    }

    fun showValues(): User {

        val missing = fillList(missingView.text.toString())
        val repeat = fillList(repeatView.text.toString())

        val user = User(repeat, missing)
        Log.e("hello", user.toString())
        return user
    }

    private fun fillList(values: String): List<String> {

        val lines = getLines(values)
        Log.e("hello lines", lines.toString())

        val resultList = mutableListOf<String>()

        lines.forEach {
            val line = processLine(it)
            resultList.addAll(line)
        }

        Log.e("hello result", resultList.toString())

        return resultList
    }

    private fun processLine(it: String): List<String> {
        val array = it.split(" ")
        val teamCode = array[0]
        val teamNumbers = array.subList(1, array.size)
        return teamNumbers.map { teamCode + it }
    }

    private fun getLines(values: String): List<String> {
        Log.e("hello values", values)
        return values.split("\n")
    }

    fun setRepeatValue(repeat: String) {
        repeatView.setText(repeat)
    }

    fun setMissingValue(missing: String) {
        missingView.setText(missing)
    }
}
