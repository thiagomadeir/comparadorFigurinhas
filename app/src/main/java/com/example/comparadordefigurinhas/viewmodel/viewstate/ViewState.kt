package com.example.comparadordefigurinhas.viewmodel.viewstate

sealed class ViewState<out T> {
    data class Success<T>(val data: T) : ViewState<T>()
    object Empty : ViewState<Nothing>()
    data class Error(val throwable: Throwable) : ViewState<Nothing>()
}
