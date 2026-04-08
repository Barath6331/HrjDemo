package com.example.hrjdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hrjdemo.ui.theme.HrjDemoTheme
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.view.Dashboard
import com.example.hrjdemo.ui.theme.view.Login
import com.example.hrjdemo.ui.theme.view.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HrjDemoTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Navigation.Splash.route) {
                    composable(Navigation.Splash.route) {
                        SplashScreen(navController)
                    }

                    composable(Navigation.Login.route) {
                        Login(navController)
                    }

                    composable(Navigation.Dashboard.route) {
                        Dashboard(navController)
                    }
                }
            }
        }
    }
}
