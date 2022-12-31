package com.covid19.covidrapidtest.ui.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.covid19.covidrapidtest.QRCodeReaderActivity
import com.covid19.covidrapidtest.ResultShowActivity
import com.covid19.covidrapidtest.RetakePictureActivity
import com.covid19.covidrapidtest.ui.allscreen.home_sub_screen.ActionButtonScreen
import com.covid19.covidrapidtest.ui.allscreen.home_sub_screen.OnGoingTest
import com.covid19.covidrapidtest.ui.allscreen.pdf_screen.PdfShowScreen
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.*
import com.covid19.covidrapidtest.ui.allscreen.screens.HomeScreen
import com.covid19.covidrapidtest.ui.allscreen.screens.ListScreen

@Composable
fun BottomNavGraph(navController: NavHostController,context:Context) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {

        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.List.route) {
            ListScreen(navController)
        }
        composable(route = Screen.OnGoingTest.route) {
            OnGoingTest(navController)
        }
        composable(route = Screen.PdfShowScreen.route) {
            PdfShowScreen(navController,Screen.ListScreen.route)
        }
        composable(route = Screen.Main.route) {
            MainScreen()
        }
//        composable( route= "CameraActivity"){
//            //CameraActivity(navController = navController)
////            CameraCompose(context, cameraX = cameraX ) {
////                if (Commons.allPermissionsGranted(context)) {
////                    cameraX.capturePhoto()
////                    navController.navigate("ShowImage")
////                }
////
////            }
//
//            context.startActivity(Intent(context, CameraActivity::class.java))
//        }
        composable(route = Screen.QRCodeReaderActivity.route) {
            navController.popBackStack()
            context.startActivity(Intent(context, QRCodeReaderActivity::class.java))
        }
        composable(route = Screen.LotNumberScreen.route) {
            //LotNumberScreen(navController) comment by sabbir 31
        }

        composable(route = Screen.BoxIntroScreen.route) {
            BoxIntroScreen(navController)
        }
        composable(route = Screen.BoxContentScreen.route) {
            BoxContentScreen(navController)
        }
        composable(route = Screen.StepScreen.route) {
            //StepScreen(navController) //comment by sabbir 31
        }
        composable(route = Screen.TimerScreen.route){
            TimerScreen(navController)
        }
        composable(route = Screen.WashHandScreen.route) {
            WashHandScreen(navController)
        }
        composable(route = Screen.SymptomScreen.route) {
            //SymptomScreen(navController) //comment by sabbir 31
        }
        composable(route = Screen.ActionButtonScreen.route) {
            ActionButtonScreen(navController)
        }



//        composable( route= "ShowImage"){
//            ShowPhoto(navController = navController,cameraX.cameraXViewModel.imageBitmap.value)
//        }
        composable(route= "RetakePictureActivity"){
            RetakePictureActivity(navController = navController)
        }
        composable(route= "ResultShowActivity"){
            ResultShowActivity()
        }

    }
}