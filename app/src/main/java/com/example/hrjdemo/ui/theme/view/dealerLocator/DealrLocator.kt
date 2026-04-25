package com.example.hrjdemo.ui.theme.view.dealerLocator

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import com.loyaltyworks.hrjohnson.model.DealerLisingRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DealrLocator(
    navController: NavController,
    viewModel: DealerLocatorViewModel = hiltViewModel(),
) {

    val dealerListingState by viewModel.dealerLocatorList.collectAsState()
    val dealerList = when (dealerListingState) {
        is UiState.Success -> {
            (dealerListingState as UiState.Success).data.dealerDetails ?: emptyList()
        }

        else -> emptyList()
    }
    val isLoading by viewModel.isLoading.collectAsState()

    val scrollState = rememberLazyListState()

    val shouldLoadMore = remember {
        derivedStateOf {
            val lastViesibleItem = scrollState.layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf false

            lastViesibleItem.index >= scrollState.layoutInfo.totalItemsCount - 2 && !isLoading && !viewModel.isLastPage
        }
    }

    LaunchedEffect(shouldLoadMore.value) {
        if (shouldLoadMore.value) {
            val request = DealerLisingRequest(
                actionType = 1,
                actorId = viewModel.preferenceHelper.getLoginDetails()?.userList?.getOrNull(0)?.userId ?: 0,
                latitude = "12.894376",
                longitude = "77.5642614"
            )

            viewModel.dealerList(request, false)
        }
    }
    LaunchedEffect(Unit) {
        val request = DealerLisingRequest(
            actionType = 1,
            actorId = viewModel.preferenceHelper.getLoginDetails()?.userList?.getOrNull(0)?.userId ?: 0,
            latitude = "12.894376",
            longitude = "77.5642614"
        )

        viewModel.dealerList(request, true)
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Dealer Locator",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                        fontSize = 15.sp,
                        color = colorResource(R.color.black)
                    )
                )
            }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                navigationIconContentColor = colorResource(R.color.black),
                titleContentColor = colorResource(R.color.black),
                containerColor = colorResource(R.color.white)
            )
        )
    }, containerColor = colorResource(R.color.colorSecondary)) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize(), state = scrollState) {
                itemsIndexed(dealerList) { index, item ->
                    Spacer(modifier = Modifier.height(5.dp))
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(vertical = 5.dp, horizontal = 15.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .background(color = colorResource(R.color.white))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            ) {
                                Spacer(modifier = Modifier.width(5.dp))
                                Image(
                                    painter = painterResource(R.drawable.person_img),
                                    contentDescription = "",
                                    modifier = Modifier.size(75.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = item.name.toString(), style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                        fontSize = 14.sp,
                                        color = colorResource(R.color.black)
                                    ),
                                    modifier = Modifier.padding(top = 15.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .height(2.dp)
                            )
                            Spacer(modifier = Modifier.height(5.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .padding(horizontal = 30.dp, vertical = 5.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .border(
                                            shape = RoundedCornerShape(10.dp),
                                            width = 1.dp,
                                            color = colorResource(R.color.mediumRed)
                                        )
                                        .background(
                                            shape = RoundedCornerShape(10.dp),
                                            color = colorResource(R.color.white)
                                        )
                                        .fillMaxWidth()
                                        .height(40.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.locator),
                                        contentDescription = "",
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))

                                    Text(
                                        text = "Direction",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                            color = colorResource(R.color.mediumRed)
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(5.dp))
                        }
                    }
                }
            }

            if (dealerListingState is UiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(50.dp).align(Alignment.Center))
            }
        }
    }
}