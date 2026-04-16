package com.example.hrjdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hrjdemo.ui.theme.HrjDemoTheme
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.view.Dashboard
import com.example.hrjdemo.ui.theme.view.loginRegister.login.Login
import com.example.hrjdemo.ui.theme.view.accountSelection.AccountSelection
import com.example.hrjdemo.ui.theme.view.loginRegister.LoginRegisterSelection
import com.example.hrjdemo.ui.theme.view.loginRegister.register.Register
import com.example.hrjdemo.ui.theme.view.loginRegister.register.Registration
import com.example.hrjdemo.ui.theme.view.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HrjDemoTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Navigation.Registration.create("8825917131")
                ){
                    composable(Navigation.Splash.route) {
                        SplashScreen(navController)
                    }

                    composable(Navigation.Login.route) {
                        Login(navController)
                    }

                    composable(Navigation.Dashboard.route) {
                        Dashboard(navController)
                    }

                    composable(Navigation.AccountSelection.route) {
                        AccountSelection(navController)
                    }

                    composable(Navigation.LoginRegisterSelection.route) {
                        LoginRegisterSelection(navController)
                    }
                    composable(Navigation.Register.route) {
                        Register(navController)
                    }

                    composable(
                        route = Navigation.Registration.route,
                        arguments = listOf(
                            navArgument("mobile") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val mobile = backStackEntry.arguments?.getString("mobile")
                        Registration(navController, mobile)
                    }
                }
            }
        }
    }
}
