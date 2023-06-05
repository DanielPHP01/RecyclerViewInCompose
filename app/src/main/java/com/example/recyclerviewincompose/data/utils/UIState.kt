package com.example.recyclerviewincompose.data.utils

sealed class UIState<out T> {
    data class Loading(val showLoading: Boolean = true) : UIState<Nothing>()
    data class Success<T>(val data: T) : UIState<T>()
    data class Error(val errorMessage: String?) : UIState<Nothing>()
    object Empty : UIState<Nothing>()
}