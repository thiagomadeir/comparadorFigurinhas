package com.example.comparadordefigurinhas.components.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.comparadordefigurinhas.GetInputFigures
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

    fun getMainUserValues(): User {

        val missing = GetInputFigures.fillList(missingView.text.toString())
        val repeat = GetInputFigures.fillList(repeatView.text.toString())

        return User(repeat, missing)
    }

    fun getGuestUserValues(): User {
        val missing = GetInputFigures.processGuestLine(missingView.text.toString(), ", ")
        val repeat = GetInputFigures.processGuestLine(repeatView.text.toString(), ", ")

        return User(repeat, missing)
    }

    fun setRepeatValue(repeat: String) {
        repeatView.setText(repeat)
    }

    fun setMissingValue(missing: String) {
        missingView.setText(missing)
    }
}
