package com.example.hrjdemo.ui.theme.view.offerAndPromotions

import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.AppButton
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.loyaltyworks.hrjohnson.model.LstPromotionJson
import com.loyaltyworks.hrjohnson.model.PromotionListRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersAndPromotions(
    navController: NavController,
    viewModel: OffersAndPromotionsViewModel = hiltViewModel(),
) {
    val regularFont = FontFamily(Font(R.font.avenirnextltpro_regular))
    val mediumFont = FontFamily(Font(R.font.avenirnextltpro_medium))
    val boldFont = FontFamily(Font(R.font.avenirnextltpro_bold))

    val offersAndPromotionListState by viewModel.offersAndPromotionList.collectAsState()
    val offerAndPromotionsList: List<LstPromotionJson> =
        (offersAndPromotionListState as? UiState.Success)
            ?.data
            ?.lstPromotionJsonList
            ?.filterNotNull()
            ?: emptyList()
    val snackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberLazyListState()

    LaunchedEffect(Unit) {
        val request = PromotionListRequest(
            actionType = "99",
            actorId = viewModel.preferenceHelper.getLoginDetails()?.userList!![0].userId!!.toString()
        )
        viewModel.getOffersAndPromotion(request)
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Offers And Promotions",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = mediumFont,
                            color = colorResource(R.color.black)
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.white),
                    navigationIconContentColor = colorResource(R.color.black),
                    titleContentColor = colorResource(R.color.black)
                )
            )
        },
        containerColor = colorResource(R.color.colorSecondary)
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(state = scrollState) {
                itemsIndexed(offerAndPromotionsList) { index, item ->
                    Spacer(modifier = Modifier.height(4.dp))
                    Card(
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 15.dp, vertical = 5.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(10.dp),
                                    color = colorResource(R.color.white)
                                )
                        ) {
                            Image(
                                painter = painterResource(R.drawable.default_img),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp),
                                contentScale = ContentScale.Fit
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 15.dp, bottom = 5.dp),
                                    text = item.promotionName.toString(),
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = colorResource(R.color.black)
                                    )
                                )

                                AppButton(
                                    "View", Modifier
                                        .height(40.dp)
                                        .width(100.dp).padding(end = 15.dp, bottom = 10.dp)
                                ) {

                                }
                            }

                            Spacer(modifier = Modifier.height(5.dp))
                        }
                    }
                }
            }

            if (offersAndPromotionListState is UiState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(80.dp)
                )
            }
        }
    }
}
