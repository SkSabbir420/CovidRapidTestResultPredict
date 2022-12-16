package com.covid19.covidrapidtest.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Main : Screen("MainScreen")
    object ListScreen : Screen("ListScreen")
    object CameraActivity : Screen("CameraActivity")
    object RetakePictureActivity : Screen("RetakePictureActivity")
    object ResultShowActivity : Screen("ResultShowActivity")
}