package com.covid19.covidrapidtest

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.covid19.covidrapidtest.ui.navigation.SetupNavGraph
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val window: Window = this.window
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//        window.statusBarColor = ContextCompat.getColor(this,R.color.black)

        setContent {
            CovidRapidTestTheme {

//                val systemUiController = rememberSystemUiController()
//                SideEffect {
//                    systemUiController.setSystemBarsColor(
//                        color = Color.Green
//                    )
//                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Navigation(this)

                    val context = LocalContext.current
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController,context)

                   // MainScreen()
                }
            }
        }


    }
}

@Composable
fun MyTopBar(){

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CovidRapidTestTheme {
       MyTopBar()
    }
}