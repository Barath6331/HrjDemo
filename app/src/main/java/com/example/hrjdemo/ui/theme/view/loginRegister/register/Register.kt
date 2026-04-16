package com.example.hrjdemo.ui.theme.view.loginRegister.register

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.AppButton
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.utils.model.EmailData
import com.example.hrjdemo.ui.theme.utils.model.EmailExistencyChekRequest
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationRequest
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsRequest
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.otp.OtpTimer
import com.example.hrjdemo.ui.theme.utils.otp.OtpView
import com.example.hrjdemo.ui.theme.view.loginRegister.login.LoginViewModel
import com.example.hrjdemo.ui.theme.view.loginRegister.login.validate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val existencyState by viewModel.existency.collectAsState()
    val sentOtpState by viewModel.getOtp.collectAsState()
    val validateOtpState by viewModel.validateOtp.collectAsState()

    var mobileNumber by rememberSaveable { mutableStateOf("") }
    var OtpText by rememberSaveable { mutableStateOf("") }
    var isOtpEnabled by rememberSaveable { mutableStateOf(false) }


    LaunchedEffect(existencyState) {
        if (existencyState is UiState.Success) {
            val respose = (existencyState as UiState.Success).data
            if (respose != 1) {
                val request = SaveAndGetOTPDetailsRequest(
                    MerchantUserName = "HRjohnson", // As gathered from token
                    UserName = "", UserId = -1, MobileNo = mobileNumber, OTPType = "Enrollment"
                )
                viewModel.getOtp(request)
            } else {
                snackbarHostState.showSnackbar("Account already exist please login")
            }
        } else if (existencyState is UiState.Error) {
            snackbarHostState.showSnackbar("Something went wrong")
        }
    }

    LaunchedEffect(sentOtpState) {
        if (sentOtpState is UiState.Success) {
            val response = (sentOtpState as UiState.Success).data
            if (response.returnValue != null && response.returnValue!! > 0) {
                isOtpEnabled = true
            } else {
                snackbarHostState.showSnackbar("Otp Sending failed")
            }
        } else if (sentOtpState is UiState.Error) {
            snackbarHostState.showSnackbar("Something went wrong")
        }
    }

    LaunchedEffect(validateOtpState) {
        if (validateOtpState is UiState.Success) {
            val response = (validateOtpState as UiState.Success).data
            if (response.returnMessage.toString().toInt() > 0) {
                navController.navigate(Navigation.Registration.create(mobileNumber))
            } else {
                navController.navigate(Navigation.Registration.create(mobileNumber))
                snackbarHostState.showSnackbar("Invalid OTP")
            }
        } else if (validateOtpState is UiState.Error) {
            snackbarHostState.showSnackbar((validateOtpState as UiState.Error).message)
        }
    }
    fun sendOtpApi() {
        val request = SaveAndGetOTPDetailsRequest(
            MerchantUserName = "HRjohnson", // As gathered from token
            UserName = "", UserId = -1, MobileNo = mobileNumber, OTPType = "Enrollment"
        )
        viewModel.getOtp(request)
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("") }, navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                    }
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.white),
                    titleContentColor = colorResource(R.color.black),
                    navigationIconContentColor = colorResource(R.color.black)
                )
            )
        }) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.colorSecondary))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(R.color.white))
                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(R.drawable.johnson_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .height(80.dp)
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                }

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Register", style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                        fontSize = 18.sp,
                        color = colorResource(R.color.black)
                    ), modifier = Modifier.padding(start = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(R.string.mobile_number), style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                        color = colorResource(R.color.black)
                    ), modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(
                            color = colorResource(R.color.white), shape = RoundedCornerShape(5.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = colorResource(R.color.grey),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    BasicTextField(
                        value = mobileNumber,
                        onValueChange = {
                            mobileNumber = it.filter { c -> c.isDigit() }.take(10)
                        },
                        modifier = Modifier.padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                            fontSize = 15.sp,
                            color = colorResource(R.color.black)
                        ),
                        enabled = !isOtpEnabled,
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.call_icon),
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))

                                Box() {
                                    if (mobileNumber.isEmpty()) {
                                        Text(
                                            text = "Enter MobileNumber", style = TextStyle(
                                                fontFamily = FontFamily(
                                                    Font(R.font.avenirnextltpro_regular),
                                                ), color = colorResource(R.color.grey)
                                            )
                                        )
                                    }
                                    innerTextField()
                                }

                            }
                        })
                }

                if (isOtpEnabled) {
                    Spacer(modifier = Modifier.height(50.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Enter OTP", style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                fontSize = 15.sp,
                                color = colorResource(R.color.black)
                            )
                        )

                        OtpTimer {
                            sendOtpApi()
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        OtpView { otp ->
                            OtpText = otp
                        }
                    }
                }
            }


            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val buttonText: String
                if (isOtpEnabled) {
                    buttonText = stringResource(R.string.submit)
                } else {
                    buttonText = stringResource(R.string.generate_otp)
                }

                AppButton(
                    text = buttonText,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 30.dp)
                ) {
                    if (isOtpEnabled) {
                        if (OtpText.isEmpty()) {
                            Toast.makeText(context, "Please enter OTP", Toast.LENGTH_LONG).show()
                        } else if (OtpText.length != 6) {
                            Toast.makeText(context, "Please enter valid OTP", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            val request = OTPValidationRequest(
                                actionType = "Get Encrypted OTP",
                                mobileNo = mobileNumber,
                                oTP = OtpText,
                                userName = ""
                            )
                            viewModel.validateOtpApi(request)
                        }
                    } else {
                        validate(mobileNumber, context) {
                            val request = EmailExistencyChekRequest(
                                actionType = "74",
                                emailData = EmailData(userName = mobileNumber)
                            )
                            viewModel.existencyCheck(request)
                        }
                    }
                }

                if (existencyState is UiState.Loading || sentOtpState is UiState.Loading || validateOtpState is UiState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .size(50.dp)
                    )
                }
            }
        }
    }
}


fun validate(mobileNumber: String, context: Context, onSuccess: () -> Unit) {
    when {
        mobileNumber.isEmpty() -> {
            Toast.makeText(context, "Please enter mobile number", Toast.LENGTH_LONG).show()
        }

        mobileNumber.length != 10 -> {
            Toast.makeText(context, "Please enter valide mobile number", Toast.LENGTH_LONG).show()
        }

        else -> {
            onSuccess()
        }
    }
}