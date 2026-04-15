package com.example.hrjdemo.ui.theme.view.loginRegister.login

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.AppButton
import com.example.hrjdemo.ui.theme.utils.model.EmailData
import com.example.hrjdemo.ui.theme.utils.model.EmailExistencyChekRequest
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationRequest
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsRequest
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.otp.OtpTimer
import com.example.hrjdemo.ui.theme.utils.otp.OtpView
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current

    val existencyState by viewModel.existency.collectAsState()
    val getOtpState by viewModel.getOtp.collectAsState()
    val validateOtpState by viewModel.validateOtp.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    
    var mobileNumber by rememberSaveable { mutableStateOf("") }
    var isOtpFieldVisible by rememberSaveable { mutableStateOf(false) }
    var isTextFieldEnabled by rememberSaveable { mutableStateOf(true) }
    var otpText by rememberSaveable { mutableStateOf("") }
    var showMobileNotExistDialog by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(validateOtpState) {
        if(validateOtpState is UiState.Success){
            val response = (validateOtpState as UiState.Success).data
            if(response.returnMessage.toString().toInt() > 0){
                snackbarHostState.showSnackbar("login Successfully")
            }else{
                snackbarHostState.showSnackbar("Invalid OTP")
            }
        }else if (validateOtpState is UiState.Error){
            snackbarHostState.showSnackbar("Something Went wrong")
        }
    }
    LaunchedEffect(existencyState) {
        if (existencyState is UiState.Success) {
            val res = (existencyState as UiState.Success).data
            if (res == 1) {
                // Number exists -> Trigger Send OTP Logic automatically
                val request = SaveAndGetOTPDetailsRequest(
                    MerchantUserName = "HRjohnson", // As gathered from token
                    UserName = "",
                    UserId = -1,
                    MobileNo = mobileNumber,
                    OTPType = "Enrollment"
                )
                viewModel.getOtp(request)
            } else {
                showMobileNotExistDialog = true
            }
        } else if (existencyState is UiState.Error) {
            snackbarHostState.showSnackbar("Error: ${(existencyState as UiState.Error).message}")
        }
    }

    LaunchedEffect(getOtpState) {
        if (getOtpState is UiState.Success) {
            val res = (getOtpState as UiState.Success).data
            if (res.returnValue != null && res.returnValue!! > 0) {
                isOtpFieldVisible = true
                isTextFieldEnabled = false
            } else {
                snackbarHostState.showSnackbar(res.returnMessage ?: "Failed to send OTP")
            }
        } else if (getOtpState is UiState.Error) {
            snackbarHostState.showSnackbar("Error: ${(getOtpState as UiState.Error).message}")
        }
    }

    fun sendOtpApi(){
        val request = SaveAndGetOTPDetailsRequest(
            MerchantUserName = "HRjohnson", // As gathered from token
            UserName = "",
            UserId = -1,
            MobileNo = mobileNumber,
            OTPType = "Enrollment"
        )
        viewModel.getOtp(request)
    }

    if (showMobileNotExistDialog) {
        AlertDialog(
            onDismissRequest = { showMobileNotExistDialog = false },
            title = { Text(text = "Information") },
            text = { Text(text = "Mobile number not exist!") },
            confirmButton = {
                TextButton(onClick = { 
                    mobileNumber = "" 
                    showMobileNotExistDialog = false 
                }) {
                    Text("OK")
                }
            }
        )
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("") }, navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                    }
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.white),
                    titleContentColor = colorResource(R.color.black),
                    navigationIconContentColor = colorResource(R.color.black)
                )
            )
        }, containerColor = colorResource(R.color.colorSecondary)
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
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
                    text = "Login", style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                        color = colorResource(R.color.black)
                    ), modifier = Modifier.padding(start = 20.dp)
                )

                Text(
                    text = stringResource(R.string.mobile_number), style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                        color = colorResource(R.color.black)
                    ), modifier = Modifier.padding(start = 20.dp, top = 10.dp)
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

                    BasicTextField(
                        value = mobileNumber,
                        onValueChange = {
                            if (isTextFieldEnabled) {
                                mobileNumber = it.filter { c -> c.isDigit() }.take(10)
                            }
                        },
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        decorationBox = { innerTextField ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.call_icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Box {
                                    if (mobileNumber.isEmpty()) {
                                        Text("Enter MobileNumber", color = Color.Gray)
                                    }
                                    innerTextField()
                                }
                            }
                        }
                    )
                }
                if (isOtpFieldVisible) {
                    Column() {

                        Spacer(modifier = Modifier.height(50.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Enter OTP",
                                style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                                    fontSize = 16.sp,
                                    color = colorResource(R.color.black)
                                )
                            )

                            OtpTimer {
                                sendOtpApi()
                            }
                        }


                        Box(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            OtpView { otp ->
                                otpText = otp
                            }
                        }
                    }
                }

            }

            var buttonText: String
            if (isOtpFieldVisible) {
                buttonText = stringResource(R.string.submit)
            } else {
                buttonText = stringResource(R.string.generate_otp)
            }
            AppButton(
                text = buttonText,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(top = 20.dp, bottom = 30.dp, start = 20.dp, end = 20.dp)
            ) {
                if (isOtpFieldVisible) {
                    if(otpText.length != 6){
                        scope.launch{
                            snackbarHostState.showSnackbar("Please Enter Valid OTP")
                        }
                    }else{
                        val request = OTPValidationRequest(
                            actionType ="Get Encrypted OTP",
                            mobileNo = mobileNumber,
                            oTP = otpText,
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

            // Display loading indicator
            if (existencyState is UiState.Loading || getOtpState is UiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}

fun validate(mobile: String, context: Context, onSuccess: () -> Unit) {
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