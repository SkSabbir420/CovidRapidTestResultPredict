package com.covid19.covidrapidtest.ui.allscreen.home_sub_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Default
import com.covid19.covidrapidtest.MyTopBar
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.OngoingTestScreen
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme

@Composable
fun OnGoingTest(){
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
                        Text(text = "Ongoing tests")
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {  }) {
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
            OngoingTestScreen()
        }
    )

}

@Preview()
@Composable
fun DefaultPreviewOnGoingTest(){
    CovidRapidTestTheme {
        OnGoingTest()
    }
}