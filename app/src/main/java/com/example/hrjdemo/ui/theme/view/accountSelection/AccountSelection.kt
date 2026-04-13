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
import androidx.compose.ui.platform.LocalContext
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


@SuppressLint("ContextCastToActivity")
@Composable
fun AccountSelection(navController: NavController) {

    val activity = LocalContext.current as Activity

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                        IconButton(onClick = { activity.finish()}) {
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

            selectTab(R.drawable.plumber_icon, "I am a Plumber") {
                navController.navigate(Navigation.LoginRegisterSelection.route)
            }

            Spacer(modifier = Modifier.height(10.dp))

            selectTab(R.drawable.csm_icon, "I am a CSM") {
                navController.navigate(Navigation.LoginRegisterSelection.route)
            }

            Spacer(modifier = Modifier.height(10.dp))
            selectTab(R.drawable.mason_icon, "I am a Mason/Contractor") {
                navController.navigate(Navigation.LoginRegisterSelection.route)
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
