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
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.DisposeScreen
import com.covid19.covidrapidtest.ui.allscreen.pdf_screen.PdfShowScreen
import com.covid19.covidrapidtest.ui.allscreen.splash_screen.AnimatedSplashScreen

@Composable
fun PdfNavGraph(navController: NavHostController,context:Context,key:String?) {
    NavHost(
        navController = navController,
        startDestination = Screen.DisposeScreen.route
    ) {
        composable(route = Screen.DisposeScreen.route) {
            DisposeScreen(navController)
        }
        composable(route = Screen.PdfShowScreen.route) {
            PdfShowScreen(navController, Screen.DisposeScreen.route,key)
        }

        composable(route = Screen.OnGoingTest.route) {
            OnGoingTest(navController = navController)
        }
        composable(route = Screen.Main.route) {
           MainScreen()
        }
        
    }
}