package com.covid19.covidrapidtest.ui.allscreen.home_sub_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.OngoingSymptomShow
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme

@Composable
fun OnGoingTest(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxHeight(0.1f),
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.image_logo
                            ),
                            contentDescription = "Image Logo",
                        )
                        Text(
                            text = "Ongoing tests",
                        fontSize = 14.sp
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.popBackStack()
                        navController.navigate(Screen.Main.route)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription =""
                        )
                    }
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },


        content = {
            //OngoingTestScreen() //comment by sabbir 1-1-2023
            OngoingSymptomShow()
        }
    )

}

@Preview()
@Composable
fun DefaultPreviewOnGoingTest(){
    CovidRapidTestTheme {
        //OnGoingTest()
    }
}