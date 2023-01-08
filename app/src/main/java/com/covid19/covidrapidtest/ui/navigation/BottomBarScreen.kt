package com.covid19.covidrapidtest.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.covid19.covidrapidtest.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        //icon = Icons.Default.Home
        icon = Icons.Outlined.Home
    )

    object List : BottomBarScreen(
        route = "list",
        title = "List",
        icon = Icons.Default.List
        //icon = Icons.Outlined.A
    )
}
