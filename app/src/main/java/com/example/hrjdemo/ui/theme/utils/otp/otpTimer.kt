package com.example.hrjdemo.ui.theme.utils.otp

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.hrjdemo.R
import kotlinx.coroutines.delay

@Composable
fun OtpTimer(onCLick: () -> Unit) {

    var timeLeft by remember { mutableStateOf(60) }
    var isRunning by remember { mutableStateOf(true) }

    // Timer logic
    LaunchedEffect(isRunning) {
        if (isRunning) {
            while (timeLeft > 0) {
                delay(1000L)
                timeLeft--
            }
            isRunning = false
        }
    }

    if (isRunning) {
        Text(
            text = "00:${timeLeft.toString().padStart(2, '0')}",
            color = Color.Black
        )
    } else {
        Text(
            text = "Resend OTP?",
            color = Color.Red,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)), fontSize = 15.sp
            ),
            modifier = Modifier.clickable {
                timeLeft = 60
                isRunning = true

                onCLick()
            }
        )
    }
}