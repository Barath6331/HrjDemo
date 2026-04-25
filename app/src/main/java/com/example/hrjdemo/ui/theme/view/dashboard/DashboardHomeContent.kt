package com.example.hrjdemo.ui.theme.view.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.Navigation
import com.example.hrjdemo.ui.theme.utils.model.DashboardItem
import com.example.hrjdemo.ui.theme.utils.network.UiState
import com.loyaltyworks.hrjohnson.model.UpdatedDashboardSingleApiRequest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardHomeContent(
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel(),
) {

    val snackbarHostState = remember { SnackbarHostState() }

    var pointBalance by rememberSaveable { mutableStateOf("") }

    val dashboardDetailsState by viewModel.dashbaordDetails.collectAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Navigation.Dashboard.route

    LaunchedEffect(Unit) {
        viewModel.getDashboardDetails(
            UpdatedDashboardSingleApiRequest(
                ActorId = viewModel.preferenceHelper.getLoginDetails()?.userList?.get(0)?.userId.toString()
            )
        )
    }

    LaunchedEffect(dashboardDetailsState) {
        if (dashboardDetailsState is UiState.Success) {
            val response = (dashboardDetailsState as UiState.Success)
            pointBalance = response.data.objCustomerDashboardList?.get(0)?.overAllPoints.toString()
        } else if (dashboardDetailsState is UiState.Error) {
            snackbarHostState.showSnackbar((dashboardDetailsState as UiState.Error).message)
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        scrimColor = colorResource(R.color.black_transprent),
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(350.dp), drawerContainerColor = Color.Transparent
            ) {
                LazyColumn {
                    item {
                        Column(
                            modifier = Modifier
                                .padding(15.dp)
                                .background(
                                    color = colorResource(R.color.colorSecondary),
                                    shape = RoundedCornerShape(15.dp)
                                )
                        ) {
                            Spacer(Modifier.height(7.dp))
                            Text(
                                text = "V26.0123.1",
                                modifier = Modifier
                                    .padding(top = 12.dp, bottom = 5.dp, end = 15.dp)
                                    .align(alignment = Alignment.End),
                                style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                    fontSize = 11.sp,
                                    color = colorResource(R.color.black)
                                ),
                                color = MaterialTheme.colorScheme.primary
                            )

                            Card(
                                elevation = CardDefaults.cardElevation(5.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Transparent
                                ),
                                modifier = Modifier
                                    .padding(horizontal = 15.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(
                                            brush = Brush.horizontalGradient(
                                                listOf(
                                                    colorResource(R.color.darkRed),
                                                    colorResource(R.color.mediumRed)
                                                )
                                            ), shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.csm_icon),
                                        contentDescription = "",
                                        modifier = Modifier.size(75.dp)
                                    )

                                    Column(
                                        modifier = Modifier
                                            .wrapContentSize()
                                            .padding(start = 10.dp, end = 5.dp, bottom = 3.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentHeight()
                                        ) {
                                            Text(
                                                text = "test", style = TextStyle(
                                                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                                                    fontSize = 15.sp,
                                                    color = colorResource(R.color.white)
                                                ), modifier = Modifier.padding(top = 10.dp)
                                            )

                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(top = 5.dp, bottom = 5.dp),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = "test", style = TextStyle(
                                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                                        fontSize = 13.sp,
                                                        color = colorResource(R.color.white)
                                                    )
                                                )

                                                Text(
                                                    text = "test", style = TextStyle(
                                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                                        fontSize = 12.sp,
                                                        color = colorResource(R.color.white)
                                                    )
                                                )
                                            }
                                        }
                                        HorizontalDivider()

                                        Row(
                                            modifier = Modifier
                                                .padding(horizontal = 7.dp)
                                                .fillMaxWidth()
                                                .height(32.dp)
                                                .padding(top = 8.dp)
                                                .background(
                                                    color = colorResource(R.color.lightRed),
                                                    shape = RoundedCornerShape(50.dp)
                                                ),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.ic_account),
                                                contentDescription = "",
                                                modifier = Modifier.size(13.dp)
                                            )

                                            Text(
                                                text = "My Account", style = TextStyle(
                                                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                                    fontSize = 13.sp,
                                                    color = colorResource(R.color.white)
                                                ), modifier = Modifier.padding(start = 10.dp)
                                            )
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(25.dp))

                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(image = R.drawable.home_icon, "Home") {
                                        scope.launch { drawerState.close() }
                                        navController.navigate(Navigation.Dashboard.route) {
                                            popUpTo(Navigation.Dashboard.route) {
                                                inclusive = false
                                            }
                                            launchSingleTop = true
                                        }
                                    })
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(image = R.drawable.qr_icon, "Scan QR Code") {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },


                                    DashboardItem(
                                        image = R.drawable.upload_code_icon, "Upload Code"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },

                                    DashboardItem(
                                        image = R.drawable.scan_history_icon, "Scan History"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    }, DashboardItem(
                                        image = R.drawable.code_status_icon, "Code Status"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    })
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(image = R.drawable.myearning_icon, "My Earning") {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },


                                    DashboardItem(
                                        image = R.drawable.cash_earning_icon, "Cash Earning"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },

                                    DashboardItem(
                                        image = R.drawable.redemption_catalog_icon,
                                        "Redemption Catalogue"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    }, DashboardItem(
                                        image = R.drawable.my_redemption_icon, "My Redemption"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },


                                    DashboardItem(
                                        image = R.drawable.redemption_planner_icon,
                                        "Redemption Planner"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    })
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(
                                        image = R.drawable.tiles_calculator_icon, "Tiles Calculator"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },


                                    DashboardItem(
                                        image = R.drawable.dealer_locator_icon, "Dealer Locator"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },

                                    DashboardItem(
                                        image = R.drawable.leaderboard_icon, "Leader Board"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },
                                    DashboardItem(image = R.drawable.my_scheme_icon, "My Scheme") {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },


                                    DashboardItem(
                                        image = R.drawable.product_portfolio_icon,
                                        "Product Portfolio"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    })
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(
                                        image = R.drawable.offers_and_promotions_icon,
                                        "Offers and Promotions"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },


                                    DashboardItem(
                                        image = R.drawable.refer_friend_icon, "Refer My Friend"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    })
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(
                                        image = R.drawable.call_helpline_icon, "Call Helpline"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },


                                    DashboardItem(
                                        image = R.drawable.refer_friend_icon, "Refer My Friend"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Dashboard.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Profile.route) {
                                                    inclusive = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    })
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(
                                        image = R.drawable.terms_and_conditions_icon,
                                        "Terms And Conditions"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    })
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            dashboardMenuItem(
                                items = listOf(
                                    DashboardItem(
                                        image = R.drawable.delete_icon, "Delete Account"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    }, DashboardItem(
                                        image = R.drawable.log_out_icon, "Logout"
                                    ) {
                                        scope.launch { drawerState.close() }
                                        if (currentRoute != Navigation.Profile.route) {
                                            navController.navigate(Navigation.Profile.route) {
                                                popUpTo(Navigation.Dashboard.route) {
                                                    inclusive = false
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    })
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }
            }
        }) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            bottomBar = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(R.color.colorPrimary))
                        .padding(bottom = 10.dp)
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .height(4.dp)
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        colorResource(R.color.colorPrimary),
                                        colorResource(R.color.mediumDarkRed),
                                        colorResource(R.color.colorPrimary)
                                    )
                                )
                            )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp, bottom = 15.dp)
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BottomNavItem(image = R.drawable.home_icon, "Home") {

                        }
                        BottomNavItem(image = R.drawable.redeem_icon, "Redeem") {

                        }
                        BottomNavItem(image = R.drawable.earning_icon, "Earning") {
                            navController.navigate(Navigation.MyEarning.route)
                        }
                        BottomNavItem(image = R.drawable.help_icon, "Help") {

                        }
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(color = colorResource(R.color.colorPrimary))
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(
                                    color = colorResource(R.color.brown),
                                    shape = RoundedCornerShape(
                                        bottomEnd = 30.dp,
                                        bottomStart = 30.dp
                                    )
                                )
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            ) {
                                IconButton(onClick = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Menu",
                                        tint = colorResource(R.color.white),
                                        modifier = Modifier.size(22.dp)
                                    )
                                }

                                Row(modifier = Modifier.wrapContentSize()) {
                                    IconButton(onClick = {}) {
                                        Icon(
                                            painter = painterResource(R.drawable.language_lcon),
                                            contentDescription = "",
                                            tint = colorResource(R.color.white),
                                            modifier = Modifier.height(22.dp)
                                        )
                                    }
                                    IconButton(onClick = { navController.navigate(Navigation.Notifiction.route) }) {
                                        Icon(
                                            painter = painterResource(R.drawable.notification_icon),
                                            contentDescription = "",
                                            tint = colorResource(R.color.white),
                                            modifier = Modifier.size(22.dp)
                                        )
                                    }
                                }
                            }
                        }

                        Card(
                            elevation = CardDefaults.elevatedCardElevation(5.dp),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .padding(start = 50.dp, end = 50.dp, top = 65.dp)
                                .height(80.dp),
                            colors = CardDefaults.cardColors(containerColor = colorResource(R.color.mediumRed))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(end = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.padding(start = 15.dp)
                                ) {
                                    Text(
                                        text = "Point Balance",
                                        style = TextStyle(
                                            fontFamily = FontFamily(
                                                Font(R.font.avenirnextltpro_regular)
                                            ),
                                            fontSize = 15.sp,
                                            color = colorResource(R.color.white)
                                        ),
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = pointBalance, style = TextStyle(
                                            fontFamily = FontFamily(
                                                Font(R.font.avenirnextltpro_bold)
                                            ),
                                            fontSize = 17.sp,
                                            color = colorResource(R.color.white)
                                        )
                                    )
                                }

                                Image(
                                    painter = painterResource(R.drawable.points_icon),
                                    contentDescription = "",
                                    modifier = Modifier.size(60.dp)
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(7.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.johnson_logo),
                            contentDescription = "",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorResource(R.color.white))
                            .padding(horizontal = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            elevation = CardDefaults.elevatedCardElevation(2.dp),
                            modifier = Modifier
                                .height(80.dp)
                                .weight(1f),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = colorResource(R.color.white))
                                    .padding(top = 10.dp, start = 15.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Total Points Redeemed", style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                        fontSize = 14.sp,
                                        color = colorResource(R.color.black)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Row(
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.coins_img),
                                        contentDescription = "",
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(7.dp))
                                    Text(
                                        text = "0", style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                                            fontSize = 16.sp,
                                            color = colorResource(R.color.black)
                                        ), modifier = Modifier.padding(top = 2.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.width(15.dp))

                        Card(
                            elevation = CardDefaults.elevatedCardElevation(2.dp),
                            modifier = Modifier
                                .height(80.dp)
                                .weight(1f),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = colorResource(R.color.white))
                                    .padding(top = 10.dp, start = 15.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Total Points Redeemed", style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                        fontSize = 14.sp,
                                        color = colorResource(R.color.black)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Row(horizontalArrangement = Arrangement.Center) {
                                    Image(
                                        painter = painterResource(R.drawable.coins_img),
                                        contentDescription = "",
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(7.dp))
                                    Text(
                                        text = "0", style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_bold)),
                                            fontSize = 16.sp,
                                            color = colorResource(R.color.black)
                                        ), modifier = Modifier.padding(top = 2.dp)
                                    )
                                }
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        itemDesign(image = R.drawable.qr_icon, "Scan\n QR Code") {

                        }
                        itemDesign(image = R.drawable.calculation_icon, "Tiles\n Calculator") {

                        }

                        itemDesign(image = R.drawable.find_dealer_img, "Find\n Dealer") {
                            navController.navigate(Navigation.DealerLocator.route)
                        }

                        itemDesign(image = R.drawable.leadership_img, "Leaderboard") {

                        }
                    }
                }

                if (dashboardDetailsState is UiState.Loading) {
                    CircularProgressIndicator(modifier = Modifier.size(30.dp))
                }
            }
        }
    }
}

@Composable
fun dashboardMenuItem(items: List<DashboardItem>) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(horizontal = 15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            items.forEach { item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clickable { item.onClick() },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Spacer(modifier = Modifier.width(10.dp))

                    Image(
                        painter = painterResource(item.image),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )

                    Text(
                        text = item.title, style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                            fontSize = 14.sp,
                            color = if (item.title == "Logout" || item.title == "Delete Account") {
                                colorResource(R.color.red)
                            } else {
                                colorResource(R.color.black)
                            }
                        ), modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun itemDesign(image: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .clickable { onClick() },
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.dashboard_item_bg),
                contentDescription = "",
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )
        }
        Text(
            text = text, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                fontSize = 12.sp,
                color = colorResource(R.color.black),
                textAlign = TextAlign.Center
            ), modifier = Modifier.padding(top = 2.dp)
        )
    }
}

@Composable
fun BottomNavItem(image: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "",
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = text, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                fontSize = 12.sp,
                color = colorResource(R.color.black),
                textAlign = TextAlign.Center
            ), modifier = Modifier.padding(top = 4.dp)
        )
    }
}