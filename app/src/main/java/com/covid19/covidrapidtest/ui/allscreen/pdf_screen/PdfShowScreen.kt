package com.covid19.covidrapidtest.ui.allscreen.pdf_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme

@Composable
fun PdfShowScreen(navController:NavController,backRoute:String,key:String?){
    Log.d("KeyPass",key.toString())
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxHeight(0.1f),
                title = {
                        Image(
                            painter = painterResource(
                                id = R.drawable.image_logo
                            ),
                            contentDescription = "Image Logo",
                        )
                },
                navigationIcon = {
                    IconButton(onClick = {

                        if(backRoute == Screen.DisposeScreen.route){
                            navController.navigate(Screen.OnGoingTest.route)
                        }else{
                        navController.popBackStack()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription =""
                        )
                    }
                },

                actions = {
                    IconButton(
                        modifier = Modifier.height(35.dp)
                            .width(35.dp),
                        onClick = {
                        //navController.navigate(Screen.ActionButtonScreen.route)
                    }) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.pdf_icon
                            ),
                            contentDescription = null,
                        )
                    }

                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },


        content = {
            PdfContentScreen()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPdfPreview() {
    CovidRapidTestTheme {
       // PdfShowScreen(navController = NavHostController(LocalContext.current),)
    }
}