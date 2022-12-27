package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import com.covid19.covidrapidtest.ui.theme.Purple40

@Composable
fun WashHandScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.image_logo
            ),
            contentDescription = "Image Logo",
        )
        Spacer(modifier = Modifier.height(64.dp))
        Image(
            painter = painterResource(
                id = R.drawable.package_picture
            ),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Wash your hands now",
            fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "You are about to enter to the test process.\nPlease make sure you wash your hand and have your test kit ready with you.",
            fontSize = 18.sp, textAlign = TextAlign.Center)

        Row(
            modifier = Modifier.fillMaxHeight()
                .padding(16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

        ) {
            OutlinedButton(
                modifier = Modifier.weight(1F)
                    .height(65.dp).padding(8.dp),
                onClick = { navController.popBackStack() }
            ) {
                Text(text = "Back")
            }
            Button(
                modifier = Modifier.weight(1F)
                    .height(65.dp).padding(8.dp),
                onClick = {
                    navController.navigate(Screen.SymptomScreen.route)
                }) {
                Text(text = "Continue")
            }

        }

    }
}