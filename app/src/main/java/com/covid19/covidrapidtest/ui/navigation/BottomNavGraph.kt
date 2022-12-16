package com.covid19.covidrapidtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.covid19.covidrapidtest.ui.allscreen.screens.HomeScreen
import com.covid19.covidrapidtest.ui.allscreen.screens.ListScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.List.route) {
            ListScreen()
        }
    }
}