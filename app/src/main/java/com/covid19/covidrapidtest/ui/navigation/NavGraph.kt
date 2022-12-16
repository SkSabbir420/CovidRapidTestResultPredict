package com.covid19.covidrapidtest.ui.navigation

import android.content.Context

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.covid19.covidrapidtest.ui.allscreen.splash_screen.AnimatedSplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController,context:Context) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }

        composable(route = Screen.Main.route) {
            //MainScreen(navController = navController)
            MainScreen()
        }
//        composable(route = Screen.CameraActivity.route) {
//            context.startActivity(Intent(context, CameraActivity::class.java))
//        }
//
//        composable(route = Screen.RetakePictureActivity.route) {
//            MainScreen(navController = navController)
//        }
//        composable(route = Screen.ResultShowActivity.route) {
//            MainScreen(navController = navController)
//        }
    }
}