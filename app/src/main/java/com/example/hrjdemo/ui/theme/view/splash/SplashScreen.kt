package com.example.hrjdemo.ui.theme.view.splash

import android.util.Log
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PrefKey
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController,viewModel: SplashViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        val isLogedIn = viewModel.preferenceHelper.getStringValue(PrefKey.LoggedIn)

        delay(2000)

        if (isLogedIn != "1" || isLogedIn.isEmpty()) {
            Log.d("fasdf","11111111111")
            navController.navigate(Navigation.AccountSelection.route) {
                popUpTo(Navigation.Splash.route) { inclusive = true }
            }
        } else {
            Log.d("fasdf","2222222")
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