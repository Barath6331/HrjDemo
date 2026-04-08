package com.example.hrjdemo.ui.theme.utils

sealed class Navigation(val route: String) {

    object Splash : Navigation("splash")
    object AccountSelection : Navigation("accountselection")
    object Login : Navigation("login")
    object Dashboard : Navigation("dashbaord")
}