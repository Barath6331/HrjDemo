package com.example.hrjdemo.ui.theme.view.loginRegister.register

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.hrjdemo.ui.theme.utils.network.UiState
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

    val snackbarHostState = remember { SnackbarHostState() }

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var pincode by rememberSaveable { mutableStateOf("") }
    var preferredDealername by rememberSaveable { mutableStateOf("") }

    val scrollState = rememberScrollState()

    val stateListingState by viewModel.stateList.collectAsState()
    val cityListingState by viewModel.cityList.collectAsState()

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
                AppButton("Submit") {}
            }

            if (stateListingState is UiState.Loading) {
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