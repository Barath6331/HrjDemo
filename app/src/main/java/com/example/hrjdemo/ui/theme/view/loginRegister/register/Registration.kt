package com.example.hrjdemo.ui.theme.view.loginRegister.register

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.AppButton
import com.example.hrjdemo.ui.theme.utils.CommonDropdown
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.ObjcustomerjsonRegister
import com.example.hrjdemo.ui.theme.utils.model.RegistrationRequest
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.example.hrjdemo.ui.theme.utils.preferenceHelper.PrefKey
import com.loyaltyworks.hrjohnson.model.City
import com.loyaltyworks.hrjohnson.model.CityListRequest
import com.loyaltyworks.hrjohnson.model.StateList
import com.loyaltyworks.hrjohnson.model.StateListRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(
    navController: NavController,
    mobile: String?,
    viewModel: RegistrationViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var pincode by rememberSaveable { mutableStateOf("") }
    var preferredDealername by rememberSaveable { mutableStateOf("") }

    val scrollState = rememberScrollState()

    val stateListingState by viewModel.stateList.collectAsState()
    val cityListingState by viewModel.cityList.collectAsState()
    val registrationState by viewModel.registrationValue.collectAsState()
    val loginState by viewModel.loginData.collectAsState()


    var selectedState by remember { mutableStateOf<StateList?>(null) }
    var stateList by remember { mutableStateOf<List<StateList>>(emptyList()) }

    var selectedCity by remember { mutableStateOf<City?>(null) }
    var cityList by remember { mutableStateOf<List<City>>(emptyList()) }

    LaunchedEffect(Unit) {
        val request = StateListRequest(
            actionType = "2",
            isActive = "true",
            sortColumn = "STATE_NAME",
            sortOrder = "ASC",
            startIndex = "1",
            countryID = "15"
        )
        viewModel.getStateList(request)
    }

    LaunchedEffect(stateListingState) {
        if (stateListingState is UiState.Success) {
            val response = (stateListingState as UiState.Success).data
            stateList = response.stateList ?: emptyList()
        } else if (stateListingState is UiState.Error) {
            snackbarHostState.showSnackbar((stateListingState as UiState.Error).message)
        }
    }

    LaunchedEffect(cityListingState) {
        if (cityListingState is UiState.Success) {
            val response = (cityListingState as UiState.Success).data
            cityList = response.cityList ?: emptyList()

        } else if (cityListingState is UiState.Error) {
            snackbarHostState.showSnackbar((cityListingState as UiState.Error).message)
        }
    }

    LaunchedEffect(registrationState) {
        if (registrationState is UiState.Success) {
            val response = (registrationState as UiState.Success).data
            if (response.returnMessage?.split("~")[0] == "1") {
                val request = LoginRequest(
                    browser = "Android",
                    loggedDeviceName = "Android",
                    userName = mobile,
                    password = "123456",
                    pushID = "fksoVJ5nTZyBUoWnX6ep5N:APA91bGYHKtec9FgFGC_fjor2Ujzxj7_zpRNoZKRz82IxuNxAnJaq-R-XwldWRCHjrzzjdkFEIJgnSiUEqRhTGYZnQe4ruj5oYfhYXWWzi_mmXaNRozG83w",
                    userActionType = "GetPasswordDetails",
                    userType = "Customer",
                    sessionId = viewModel.preferenceHelper.getStringValue(PrefKey.CustomerType),
                    userIp = "",
                    loggedDeviceID = "",
                )
                viewModel.loginRequest(request)
            } else {
                snackbarHostState.showSnackbar("Registration Failed!")
            }
        } else if (registrationState is UiState.Error) {
            snackbarHostState.showSnackbar((registrationState as UiState.Error).message)
        }
    }

    LaunchedEffect(loginState) {
        if (loginState is UiState.Success) {
            val response = (loginState as UiState.Success).data
            if (response.userList?.get(0)?.result == 1) {
                viewModel.preferenceHelper.setStringValue(PrefKey.LoggedIn, "1")
                viewModel.preferenceHelper.setLoginDetails(response)
                navController.navigate(Navigation.Dashboard.route) {
                    navController.currentDestination?.route?.let {
                        popUpTo(it) {
                            inclusive = true
                        }
                    }
                }
            }else{
                snackbarHostState.showSnackbar("Login Failed")
            }
        } else if (loginState is UiState.Error) {
            snackbarHostState.showSnackbar((loginState as UiState.Error).message)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }, topBar = {
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
        }, containerColor = colorResource(R.color.colorSecondary)
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Register", style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                        fontSize = 18.sp,
                        color = colorResource(R.color.black)
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = buildAnnotatedString {
                        append(stringResource(R.string.mobile_number))
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append(" *")
                        }
                    }, style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                        fontSize = 13.sp
                    )
                )

                Spacer(modifier = Modifier.height(7.dp))

                Box(
                    modifier = Modifier
                        .height(45.dp)
                        .fillMaxWidth()
                        .background(
                            color = colorResource(R.color.white), shape = RoundedCornerShape(5.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = colorResource(R.color.white),
                            shape = RoundedCornerShape(5.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    if (mobile != null) {
                        Text(
                            text = mobile,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                fontSize = 14.sp,
                                color = colorResource(R.color.grey)
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                textFeild(
                    title = "Name(As per Aadhaar)",
                    isMandatroy = true,
                    value = name,
                    onValuechage = { name = it },
                    placeHolder = "Name",
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,
                    ),
                )

                Spacer(modifier = Modifier.height(10.dp))

                textFeild(
                    title = "Email",
                    isMandatroy = false,
                    value = email,
                    onValuechage = { email = it },
                    placeHolder = "Email",
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                textFeild(
                    title = "Address",
                    isMandatroy = true,
                    value = address,
                    onValuechage = { address = it },
                    placeHolder = "Address",
                    singleLine = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                textFeild(
                    title = "Pincode",
                    isMandatroy = true,
                    value = pincode,
                    onValuechage = { pincode = it.filter { c -> c.isDigit() }.take(6) },
                    placeHolder = "Pincode",
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                CommonDropdown(label = buildAnnotatedString {
                    append("State")
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("*")
                    }
                }, items = stateList, selectedItem = selectedState, onItemSelected = {
                    selectedState = it

                    // same logic as your fragment
                    if (it.stateId != null) {
                        val request = CityListRequest(
                            actionType = "2",
                            isActive = "true",
                            sortColumn = "CITY_NAME",
                            sortOrder = "ASC",
                            startIndex = "1",
                            stateId = selectedState.toString()
                        )

                        viewModel.getCityList(request)
                    }
                }, itemLabel = { it.stateName ?: "" })

                Spacer(modifier = Modifier.height(10.dp))

                CommonDropdown(label = buildAnnotatedString {
                    append("City")
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("*")
                    }
                }, items = cityList, selectedItem = selectedCity, onItemSelected = {
                    selectedCity = it

                    // same logic as your fragment
                    if (it.cityId != null) {

                    }
                }, itemLabel = { it.cityName ?: "" })

                Spacer(modifier = Modifier.height(10.dp))

                textFeild(
                    title = "Preferred Dealer Name",
                    isMandatroy = true,
                    value = preferredDealername,
                    onValuechage = { preferredDealername = it },
                    placeHolder = "Preferred Dealer Name",
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                    )
                )

                Spacer(modifier = Modifier.height(50.dp))
                AppButton("Submit") {
                    Log.d("asfsadf", "" + selectedState?.stateId)
                    val validate = validate(
                        context = context,
                        name = name,
                        email = email,
                        address = address,
                        state = selectedState?.stateId.toString(),
                        city = selectedCity?.cityId.toString(),
                        pincode = pincode,
                        perferredDealerName = preferredDealername
                    )

                    if (validate) {
                        val request = RegistrationRequest(
                            actiontype = "0",
                            objcustomerjson = ObjcustomerjsonRegister(
                                firstName = name,
                                lastName = "",
                                email = email,
                                mobile = mobile,
                                address1 = address,
                                cityid = selectedCity?.cityId.toString(),
                                countryId = 15,
                                customertypeid = viewModel.preferenceHelper.getStringValue(PrefKey.CustomerType)
                                    .toInt(),
                                preferedDealerName = preferredDealername,
                                referrerCode = "",
                                registrationSource = "3",
                                stateId = selectedState?.stateId,
                                zip = pincode,
                                loyaltyId = mobile
                            )
                        )

                        viewModel.registrationApi(request)
                    }
                }
            }

            if (stateListingState is UiState.Loading || cityListingState is UiState.Loading || registrationState is UiState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp)
                        .align(alignment = Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun textFeild(
    title: String,
    isMandatroy: Boolean,
    value: String,
    onValuechage: (String) -> Unit,
    placeHolder: String,
    singleLine: Boolean,
    keyboardOptions: KeyboardOptions,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        if (isMandatroy) {
            Text(
                text = buildAnnotatedString {
                    append(title)
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("*")
                    }
                }, style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.black)
                )
            )
        } else {
            Text(
                text = title, style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.black)
                )
            )
        }


        Spacer(modifier = Modifier.height(7.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .background(color = colorResource(R.color.white), shape = RoundedCornerShape(5.dp))
                .border(
                    width = 0.5.dp,
                    color = colorResource(R.color.grey),
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(horizontal = 10.dp), contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValuechage,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = keyboardOptions,
                singleLine = singleLine,
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                    fontSize = 14.sp,
                    color = colorResource(R.color.black)
                ),
                decorationBox = { innerTextFeild ->

                    Box(modifier = Modifier.fillMaxWidth()) {
                        if (value.isEmpty()) {
                            Text(
                                text = "Enter $placeHolder", style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                    fontSize = 14.sp,
                                    color = colorResource(R.color.grey)
                                )
                            )
                        }
                    }
                    innerTextFeild()
                })
        }
    }
}

fun validate(
    context: Context,
    name: String,
    email: String,
    address: String,
    state: String,
    city: String,
    pincode: String,
    perferredDealerName: String,
): Boolean {
    var boolean = false
    if (name.isEmpty()) {
        Toast.makeText(context, "Please Enter Name", Toast.LENGTH_LONG).show()
    } else if (email.isEmpty()) {
        Toast.makeText(context, "Please Enter Email", Toast.LENGTH_LONG).show()
    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        Toast.makeText(context, "Please Enter Valid Email", Toast.LENGTH_LONG).show()
    } else if (address.isEmpty()) {
        Toast.makeText(context, "Please Enter Address", Toast.LENGTH_LONG).show()
    } else if (state.isEmpty() || state == "null") {
        Toast.makeText(context, "Please Select State", Toast.LENGTH_LONG).show()
    } else if (city.isEmpty() || city == "null") {
        Toast.makeText(context, "Please Select City", Toast.LENGTH_LONG).show()
    } else if (pincode.isEmpty()) {
        Toast.makeText(context, "Please Enter Pincode", Toast.LENGTH_LONG).show()
    } else if (pincode.length != 6) {
        Toast.makeText(context, "Please Enter Valid Pincode", Toast.LENGTH_LONG).show()
    } else if (perferredDealerName.isEmpty()) {
        Toast.makeText(context, "Please Enter Preferred Dealer Name", Toast.LENGTH_LONG).show()
    } else {
        boolean = true
    }
    return boolean
}