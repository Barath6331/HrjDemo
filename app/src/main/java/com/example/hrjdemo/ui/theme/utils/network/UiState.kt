package com.example.hrjdemo.ui.theme.utils.network

sealed class UiState<out T> {
    object Idle : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val message: String, val code: Int? = null) : UiState<Nothing>()
}