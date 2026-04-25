package com.example.hrjdemo.ui.theme.view.notification

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.loyaltyworks.hrjohnson.model.HistoryNotificationRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Nofitification(
    navController: NavController,
    viewModel: NotificationViewModel = hiltViewModel(),
) {

    val notificationListState by viewModel.notification.collectAsState()
    val notificationListing = when (notificationListState) {
        is UiState.Success -> {
            (notificationListState as UiState.Success).data.lstPushHistoryJson ?: emptyList()
        }

        else -> emptyList()
    }

    val scrollState = rememberLazyListState()
    val isLoading by viewModel.isLoading.collectAsState()

    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem =
                scrollState.layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf false

                lastVisibleItem.index >= scrollState.layoutInfo.totalItemsCount - 2 && !isLoading && !viewModel.isLastdata
        }
    }

    LaunchedEffect(shouldLoadMore.value) {
        if(shouldLoadMore.value){
            val request = HistoryNotificationRequest(
                ActionType = "0",
                ActorId = viewModel.preferenceHelper.getLoginDetails()?.userList!![0].userId.toString(),
                LoyaltyId = viewModel.preferenceHelper.getLoginDetails()?.userList!![0].userName
            )

            viewModel.notificationList(request, false)
        }
    }

    LaunchedEffect(Unit) {
        val request = HistoryNotificationRequest(
            ActionType = "0",
            ActorId = viewModel.preferenceHelper.getLoginDetails()?.userList!![0].userId.toString(),
            LoyaltyId = viewModel.preferenceHelper.getLoginDetails()?.userList!![0].userName
        )

        viewModel.notificationList(request, true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Notification", style = TextStyle(
                            fontFamily = FontFamily(
                                Font(R.font.avenirnextltpro_medium)
                            ), fontSize = 15.sp,
                            color = colorResource(R.color.black)
                        )
                    )
                }, navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.white),
                    navigationIconContentColor = colorResource(R.color.black),
                    titleContentColor = colorResource(R.color.white)
                )
            )
        },
        containerColor = colorResource(R.color.colorSecondary)
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState) {
                itemsIndexed(notificationListing) { index, item ->
                    Spacer(modifier = Modifier.height(5.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 15.dp, vertical = 5.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(R.color.white))
                        ) {
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                painter = painterResource(R.drawable.johnson_logo),
                                contentDescription = "",
                                modifier = Modifier.size(80.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column() {
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = item.title.toString(),
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                        fontSize = 16.sp,
                                        color = colorResource(R.color.black)
                                    )
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(
                                    text = item.pushMessage.toString(),
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                        fontSize = 14.sp,
                                        color = colorResource(R.color.black)
                                    )
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(
                                    text = "bk",
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                        fontSize = 14.sp,
                                        color = colorResource(R.color.black)
                                    )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 15.dp)
                                ) {
                                    Row() {
                                        Image(
                                            painter = painterResource(R.drawable.calender_icon),
                                            contentDescription = "",
                                            modifier = Modifier.size(10.dp)
                                        )

                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = item.jCreatedDate.toString(),
                                            style = TextStyle(
                                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                                fontSize = 13.sp,
                                                color = colorResource(R.color.black)
                                            )
                                        )
                                    }

                                    Image(
                                        painter = painterResource(R.drawable.read),
                                        contentDescription = "",
                                        modifier = Modifier.size(10.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
