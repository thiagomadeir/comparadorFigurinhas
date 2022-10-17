package com.example.comparadordefigurinhas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.comparadordefigurinhas.CompareFigures
import com.example.comparadordefigurinhas.model.User
import com.example.comparadordefigurinhas.viewmodel.viewstate.ViewState

class MainViewModel : ViewModel() {

    private val _figuresViewState = MutableLiveData<ViewState<Pair<List<String>, List<String>>>>()
    val figuresViewState: LiveData<ViewState<Pair<List<String>, List<String>>>> =
        Transformations.map(_figuresViewState) { it }

    fun compareFigures(userOne: User, userTwo: User) {

        try {

            val resultOne = CompareFigures.compare(userOne.missing, userTwo.repeated)
            val resultTwo = CompareFigures.compare(userTwo.missing, userOne.repeated)

            _figuresViewState.value = ViewState.Success(Pair(resultOne, resultTwo))

        } catch (e: Exception) {
            e.printStackTrace()
            _figuresViewState.value = ViewState.Error(e)
        }
    }
}
