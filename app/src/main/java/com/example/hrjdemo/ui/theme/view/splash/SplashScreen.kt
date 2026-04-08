package com.example.hrjdemo.ui.theme.view.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.Navigation
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val viewModel: SplashViewModel = viewModel()

    LaunchedEffect(Unit) {
        val isLogedIn = viewModel.isLogedIn

        delay(2000)

        if (isLogedIn == true) {
            navController.navigate(Navigation.AccountSelection.route) {
                popUpTo(Navigation.Splash.route) { inclusive = true }
            }
        } else {
            navController.navigate(Navigation.Dashboard.route) {
                popUpTo(Navigation.Splash.route) {
                    inclusive = true
                }
            }
        }
    }
    Box {
        Image(
            painter = painterResource(R.drawable.splash_bg),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(R.drawable.johnson_logo),
            contentDescription = "",
            modifier = Modifier
                .align(
                    Alignment.Center
                )
                .fillMaxSize()
                .padding(end = 50.dp)
        )
    }
}