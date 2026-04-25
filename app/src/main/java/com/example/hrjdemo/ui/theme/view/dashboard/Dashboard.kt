package com.example.hrjdemo.ui.theme.view.dashboard

import android.app.Notification
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.view.Profile
import com.example.hrjdemo.ui.theme.view.dealerLocator.DealrLocator
import com.example.hrjdemo.ui.theme.view.myEarning.MyEarning
import com.example.hrjdemo.ui.theme.view.notification.Nofitification

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Dashboard.route
    ) {

        composable(Navigation.Dashboard.route) {
            DashboardHomeContent(navController)
        }

        composable(Navigation.Profile.route) {
            Profile(navController)
        }

        composable(Navigation.MyEarning.route) {
            MyEarning(navController)
        }

        composable(Navigation.Notifiction.route) {
            Nofitification(navController)
        }

        composable(Navigation.DealerLocator.route) {
            DealrLocator(navController)
        }
    }
}