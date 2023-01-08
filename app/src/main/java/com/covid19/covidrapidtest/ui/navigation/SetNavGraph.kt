package com.covid19.covidrapidtest.ui.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.covid19.covidrapidtest.CameraActivity
import com.covid19.covidrapidtest.QRCodeReaderActivity
import com.covid19.covidrapidtest.ui.allscreen.home_sub_screen.ActionButtonScreen
import com.covid19.covidrapidtest.ui.allscreen.home_sub_screen.OnGoingTest
import com.covid19.covidrapidtest.ui.allscreen.pdf_screen.PdfShowScreen
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

        composable(route = Screen.QRCodeReaderActivity.route) {
            //context.startActivity(Intent(context, CameraActivity::class.java))
            //navController.popBackStack()
            context.startActivity(Intent(context, QRCodeReaderActivity::class.java))
        }

        composable(route = Screen.OnGoingTest.route) {
            OnGoingTest(navController)
        }
//        composable(route = Screen.ActionButtonScreen.route) {
//            ActionButtonScreen()
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