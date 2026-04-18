package com.example.hrjdemo.ui.theme.view


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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hrjdemo.R
import com.example.hrjdemo.ui.theme.utils.Navigation
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(mainNavController: NavController) {

    val scrollState = rememberScrollState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // Inner NavController for the Dashboard's sub-screens
    val dashboardNavController = rememberNavController()

    // Track current route to highlight the selected item and update top bar
    val navBackStackEntry by dashboardNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "dashboard_home"

    val topBarTitle = when (currentRoute) {
        "dashboard_home" -> "Dashboard"
        Navigation.Profile.route -> "Profile"
        else -> "Hrj Demo"
    }
    ModalNavigationDrawer(
        drawerState = drawerState, gesturesEnabled = drawerState.isOpen,
        scrimColor = Color.Transparent, drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(350.dp),
                drawerContainerColor = Color.Transparent
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(
                            color = colorResource(R.color.colorSecondary),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .verticalScroll(scrollState)
                ) {
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "V26.0123.1",
                        modifier = Modifier
                            .padding(12.dp)
                            .align(alignment = Alignment.End),
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = colorResource(R.color.black),
                            fontWeight = FontWeight.Bold
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
                            .padding(horizontal = 10.dp)
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
                                modifier = Modifier.size(80.dp)
                            )

                            Column(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 10.dp)
                                        .wrapContentHeight()
                                ) {
                                    Text(
                                        text = "test", style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                                            fontSize = 15.sp,
                                            color = colorResource(R.color.white)
                                        )
                                    )

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 10.dp, bottom = 5.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "test", style = TextStyle(
                                                fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                                fontSize = 12.sp,
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
                                        .height(35.dp)
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
                                        modifier = Modifier.size(15.dp)
                                    )

                                    Text(
                                        text = "My Account", style = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                            fontSize = 15.sp,
                                            color = colorResource(R.color.white)
                                        ),
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    dashboardMenuItem(image = R.drawable.home_icon, "Home") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != "dashboard_home") {
                            dashboardNavController.navigate("dashboard_home") {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    dashboardMenuItem(image = R.drawable.qr_icon, "Scan QR Code") {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Navigation.Profile.route) {
                            dashboardNavController.navigate(Navigation.Profile.route) {
                                popUpTo("dashboard_home") { inclusive = false }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                }

            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = topBarTitle) }, navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }, colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }) { paddingValues ->
            NavHost(
                navController = dashboardNavController,
                startDestination = "dashboard_home",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable("dashboard_home") {
                    DashboardHomeContent()
                }
                composable(Navigation.Profile.route) {
                    Profile(mainNavController)
                }
            }
        }
    }
}

@Composable
fun DashboardHomeContent() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to the Dashboard",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun dashboardMenuItem(image: Int, title: String, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(horizontal = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    color = colorResource(R.color.white),
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = title,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.black)
                ),
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}