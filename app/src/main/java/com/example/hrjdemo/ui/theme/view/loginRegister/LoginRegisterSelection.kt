package com.example.hrjdemo.ui.theme.view.loginRegister

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginRegisterSelection(navController: NavController) {


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
        Column() {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .background(color = colorResource(R.color.white))
            ) {
                Spacer(modifier = Modifier.height(35.dp))

                Image(
                    painter = painterResource(R.drawable.johnson_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                        .fillMaxWidth()
                        .height(80.dp)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Text(
                text = "Login/Create Your Account", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                    color = colorResource(R.color.black)
                ),
                modifier = Modifier.padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            commonFeild(R.drawable.login_icon, "Login") {
                navController.navigate(Navigation.Login.route)
            }

            Spacer(modifier = Modifier.height(10.dp))

            commonFeild(R.drawable.register_icon, "Register") {

            }
        }

    }
}

@Composable
fun commonFeild(image: Int, text: String, onCLick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(start = 20.dp, end = 20.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(10.dp))
            .background(shape = RoundedCornerShape(10.dp), color = colorResource(R.color.white))
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
                color = colorResource(R.color.lightRed)
            )
            .clickable {
                onCLick()
            }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier.size(55.dp)
                )

                Text(
                    text = text, style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                        color = colorResource(R.color.black)
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }

            Image(
                painter = painterResource(R.drawable.right_arrow),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.CenterEnd)
                    .height(20.dp)
                    .padding(end = 20.dp)
            )
        }
    }
}