package com.covid19.covidrapidtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.covid19.covidrapidtest.feature_performtest.presentation.PerformTestScreen
import com.covid19.covidrapidtest.ui.navigation.MainScreen
import com.covid19.covidrapidtest.ui.navigation.SetupNavGraph
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CovidRapidTestTheme {
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