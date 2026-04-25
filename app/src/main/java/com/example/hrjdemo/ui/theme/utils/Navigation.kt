package com.example.hrjdemo.ui.theme.utils

sealed class Navigation(val route: String) {

    object Splash : Navigation("splash")
    object AccountSelection : Navigation("accountselection")
    object LoginRegisterSelection: Navigation("loginregisterselection")
    object Login : Navigation("login")
    object Register: Navigation("register")
    object Dashboard : Navigation("dashbaord")
    object DashboardHomeContent : Navigation("dashbaordContent")
    object Profile : Navigation("profile")
    object Notifiction : Navigation("notification")
    object MyEarning: Navigation("myearning")
    object DealerLocator: Navigation("dealerLocator")

    object Registration : Navigation("registration/{mobile}") {
        fun create(mobile: String) = "registration/$mobile"
    }
}