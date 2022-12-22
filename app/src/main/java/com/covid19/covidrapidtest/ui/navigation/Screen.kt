package com.covid19.covidrapidtest.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Main : Screen("MainScreen")
    object ListScreen : Screen("ListScreen")
    object LotNumberScreen : Screen("LotNumberScreen")
    object BoxIntroScreen : Screen("BoxIntroScreen")
    object BoxContentScreen : Screen("BoxContentScreen")
    object StepScreen : Screen("StepScreen")
    object WashHandScreen : Screen("WashHandScreen")
    object SymptomScreen : Screen("SymptomScreen")
    object TimerScreen: Screen("TimerScreen")
    object CameraActivity : Screen("CameraActivity")
    object QRCodeReaderActivity : Screen("QRCodeReaderActivity")
    object OnGoingTest : Screen("OnGoingTest")
    object RetakePictureActivity : Screen("RetakePictureActivity")
    object ResultShowActivity : Screen("ResultShowActivity")
    object ActionButtonScreen: Screen("ActionButtonScreen")
}