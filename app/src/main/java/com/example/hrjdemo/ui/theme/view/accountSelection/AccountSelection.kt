@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hrjdemo.ui.theme.view.accountSelection


import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest

@SuppressLint("ContextCastToActivity")
@Composable
fun AccountSelection(
    navController: NavController,
    viewModel: AccountSelectionViewModel = hiltViewModel(),
) {

    val activity = LocalContext.current as Activity
    val uiState by viewModel.accountTypeData.collectAsState()

    // Values to bind the text (keeping default fallbacks)
    var plumberText by remember { mutableStateOf("-") }
    var csmText by remember { mutableStateOf("-") }
    var masonText by remember { mutableStateOf("-") }

    // IDs from your old code to possibly pass in navigation later
    var plumberId by remember { mutableStateOf("") }
    var csmId by remember { mutableStateOf("") }
    var masonId by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }

    // Make the API call when the screen launches
    LaunchedEffect(Unit) {
        viewModel.getAccountType(AccountTypeRequest(actionType = 61))
    }

    // Handle the state changes
    LaunchedEffect(uiState) {
        when (uiState) {
            is UiState.Success -> {
                val response = (uiState as UiState.Success).data
                if (!response.lstAttributesDetails.isNullOrEmpty()) {
                    val list = response.lstAttributesDetails!!
                    
                    // Safely grab index using getOrNull to prevent IndexOutOfBoundsException crash
                    plumberId = list.getOrNull(0)?.attributeId?.toString() ?: ""
                    csmId = list.getOrNull(1)?.attributeId?.toString() ?: ""
                    masonId = list.getOrNull(2)?.attributeId?.toString() ?: ""

                    // Safely binding the Texts
                    plumberText = "I am a " + (list.getOrNull(0)?.attributeType ?: "Plumber")
                    csmText = "I am a " + (list.getOrNull(1)?.attributeType ?: "CSM")
                    masonText = "I am a " + (list.getOrNull(2)?.attributeType ?: "Mason/Contractor")
                } else {
                    snackbarHostState.showSnackbar("Something went wrong, no data found")
                }
            }
            is UiState.Error -> {
                snackbarHostState.showSnackbar((uiState as UiState.Error).message)
            }
            else -> {}
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { activity.finish() }) {
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
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxHeight()) {
            Column(modifier = Modifier.background(colorResource(R.color.colorSecondary))) {
                Column(
                    modifier = Modifier
                        .background(color = colorResource(R.color.white))
                ) {
                    Image(
                        painter = painterResource(R.drawable.johnson_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 35.dp, bottom = 30.dp)
                            .fillMaxWidth()
                            .height(80.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Select Your",
                    modifier = Modifier.padding(start = 25.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(R.color.black),
                        fontFamily = FontFamily(Font((R.font.avenirnextltpro_medium)))
                    )
                )

                Text(
                    text = "Customer Type",
                    modifier = Modifier.padding(start = 20.dp, top = 7.dp),
                    style = TextStyle(
                        color = colorResource(R.color.black),
                        fontSize = 23.sp,
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold))
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                selectTab(R.drawable.plumber_icon, plumberText) {
                    viewModel.saveCustomerID(plumberId)
                    navController.navigate(Navigation.LoginRegisterSelection.route)
                }

                Spacer(modifier = Modifier.height(10.dp))

                selectTab(R.drawable.csm_icon, csmText) {
                    viewModel.saveCustomerID(csmId)
                    navController.navigate(Navigation.LoginRegisterSelection.route)
                }

                Spacer(modifier = Modifier.height(10.dp))
                selectTab(R.drawable.mason_icon, masonText) {
                    viewModel.saveCustomerID(masonId)
                    navController.navigate(Navigation.LoginRegisterSelection.route)
                }
            }

            // Show Loader when state is Loading
            if (uiState is UiState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun selectTab(image: Int, text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(65.dp)
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = colorResource(R.color.lightRed),
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = colorResource(R.color.white), shape = RoundedCornerShape(10.dp))
            .clickable { onClick() }
    ) {

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .size(55.dp)
                    .padding(start = 10.dp)
            )

            Text(
                text = text,
                modifier = Modifier
                    .padding(start = 10.dp),
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium))
                )
            )
        }


        Image(
            painter = painterResource(R.drawable.right_arrow),
            contentDescription = "",
            modifier = Modifier
                .height(20.dp)
                .padding(end = 20.dp)
                .align(Alignment.CenterEnd)
        )
    }
}
