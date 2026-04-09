package com.example.hrjdemo.ui.theme.view.loginRegister.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.OtpView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.white),
                    titleContentColor = colorResource(R.color.black),
                    navigationIconContentColor = colorResource(R.color.black)
                )
            )
        },
        containerColor = colorResource(R.color.colorSecondary)
    ) { padding ->
        Box() {
            var mobileNumber by rememberSaveable { mutableStateOf("") }
            Column() {
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .background(color = colorResource(R.color.white))
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(R.drawable.johnson_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                        color = colorResource(R.color.black)
                    ),
                    modifier = Modifier.padding(start = 20.dp)
                )

                Text(
                    text = stringResource(R.string.mobile_number),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                        color = colorResource(R.color.black)
                    ),
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .padding(start = 20.dp, end = 20.dp)
                        .background(
                            shape = RoundedCornerShape(5.dp),
                            color = colorResource(R.color.white)
                        )
                        .border(
                            width = (1.dp),
                            color = colorResource(R.color.grey),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    BasicTextField(
                        value = mobileNumber,
                        onValueChange = { mobileNumber = it },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {

                            }
                        )
                    )
                }



                Box(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    OtpView { otp ->
                        println("OTP entered: $otp")

                        if (otp.length == 6) {
                            // verify OTP
                        }
                    }
                }
            }
        }
    }

}
