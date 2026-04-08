package com.example.hrjdemo.ui.theme.view.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SplashViewModel: ViewModel() {

    var isLogedIn by mutableStateOf<Boolean?>(null)

    init {
        checkLogin()
    }

    private fun checkLogin(){
        isLogedIn = true
    }
}