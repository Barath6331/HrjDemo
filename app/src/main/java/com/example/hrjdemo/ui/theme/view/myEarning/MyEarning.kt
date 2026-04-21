package com.example.hrjdemo.ui.theme.view.myEarning

import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.loyaltyworks.hrjohnson.model.MyEarningRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEarning(navController: NavController, viewmodel: MyEarningViewModel = hiltViewModel()) {

    val myEarningListState by viewmodel.myEarningList.collectAsState()
    val myEarningListing = when (myEarningListState) {
        is UiState.Success -> {
            (myEarningListState as UiState.Success)
                .data.lstRewardTransJsonDetails ?: emptyList()
        }

        else -> emptyList()
    }
    LaunchedEffect(Unit) {
        viewmodel.getEarningList(
            MyEarningRequest(
                actorId = viewmodel.preferenceHelper.getLoginDetails()?.userList!![0].userId!!,
                behaviorId = -1,
                jFromDate = "",
                jToDate = "",
                startIndex = 1,
                pageSize = 20
            )
        )
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "My Earning",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                        fontSize = 18.sp,
                        color = colorResource(
                            R.color.black
                        )
                    )
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(R.color.white),
                navigationIconContentColor = colorResource(R.color.black),
                titleContentColor = colorResource(R.color.black)
            )
        )
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn() {
                items(myEarningListing) { item ->
                    Spacer(modifier = Modifier.height(5.dp))
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 20.dp, vertical = 5.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(R.color.white))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 15.dp, bottom = 5.dp, start = 15.dp, end = 15.dp)
                            ) {
                                Column() {
                                    Text(
                                        text = "Program Name",
                                        style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                            fontSize = 13.sp,
                                            color = colorResource(R.color.black)
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = item.transactionType.toString(),
                                        style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                            fontSize = 14.sp,
                                            color = colorResource(R.color.black)
                                        )
                                    )
                                }

                                Column(
                                    horizontalAlignment = Alignment.End,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = item.rewardPoints.toString(),
                                        style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                            fontSize = 14.sp,
                                            color = colorResource(R.color.black)
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Points",
                                        style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                            fontSize = 13.sp,
                                            color = colorResource(R.color.black)
                                        )
                                    )
                                }
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 10.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp))
                                        .background(
                                            color = colorResource(R.color.lightGrey),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(15.dp)
                                ) {

                                    Column() {
                                        Text(
                                            text = "Remarks",
                                            style = TextStyle(
                                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                                fontSize = 13.sp,
                                                color = colorResource(R.color.black)
                                            )
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))

                                        Text(
                                            text = item.bonusName.toString(),
                                            style = TextStyle(
                                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                                fontSize = 14.sp,
                                                color = colorResource(R.color.black)
                                            )
                                        )
                                    }

                                    Column(
                                        horizontalAlignment = Alignment.End,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Date",
                                            style = TextStyle(
                                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                                fontSize = 13.sp,
                                                color = colorResource(R.color.black)
                                            )
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))

                                        Text(
                                            text = item.jTranDate.toString(),
                                            style = TextStyle(
                                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                                fontSize = 14.sp,
                                                color = colorResource(R.color.black)
                                            )
                                        )
                                    }

                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                }
            }

            if (myEarningListState is UiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(30.dp))
            }
        }
    }
}