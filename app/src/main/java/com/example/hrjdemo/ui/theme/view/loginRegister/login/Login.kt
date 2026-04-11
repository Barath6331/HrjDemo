package com.example.hrjdemo.ui.theme.view.loginRegister.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.hrjdemo.ui.theme.utils.AppButton
import com.example.hrjdemo.ui.theme.utils.OtpView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {

    val context = LocalContext.current
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
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            var mobileNumber by rememberSaveable { mutableStateOf("") }
            var OtpFeildVisiblity by rememberSaveable { mutableStateOf(false) }
            var isTextFieldEnabled by rememberSaveable { mutableStateOf(true) }
            Column() {
                Column(
                    modifier = Modifier
                        .background(color = colorResource(R.color.white))
                        .wrapContentHeight()
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
                        .padding(horizontal = 16.dp)
                        .background(
                            color = colorResource(R.color.white),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(R.color.grey),
                            RoundedCornerShape(5.dp)
                        ),
                    contentAlignment = Alignment.CenterStart
                ) {

                    if (mobileNumber.isEmpty()) {
                        Text(
                            text = "Enter MobileNumber",
                            color = Color.Gray,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }

                    BasicTextField(
                        value = mobileNumber,
                        onValueChange = {
                            if (isTextFieldEnabled) {
                                mobileNumber = it.filter { c -> c.isDigit() }.take(10)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                validate(mobileNumber,context){
                                    OtpFeildVisiblity = true
                                    isTextFieldEnabled = false
                                }
                            }
                        ),
                        textStyle = TextStyle(
                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                            color = colorResource(R.color.black),
                            fontSize = 14.sp
                        )
                    )
                }
                if (OtpFeildVisiblity) {
                    Box(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth(),
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

            AppButton(
                text = "Login",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(top = 20.dp, bottom = 30.dp, start = 20.dp, end = 20.dp)
            ) {
                validate(mobileNumber,context){
                    OtpFeildVisiblity = true
                    isTextFieldEnabled = false
                }
            }
        }
    }

}
fun validate(mobile : String, context: Context, onSuccess:()-> Unit){
    when {
        mobile.isEmpty() -> {
            Toast.makeText(context, "Please Enter Mobile Number", Toast.LENGTH_LONG).show()
        }
        mobile.length != 10 -> {
            Toast.makeText(context, "Please Enter Valid Mobile Number", Toast.LENGTH_LONG).show()
        }
        else -> onSuccess()
    }
}