package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import com.covid19.covidrapidtest.ui.theme.Purple40

@Composable
fun BoxIntroScreen(navController: NavHostController) {
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
        Text(text = "You are now about to start the process.\nThe test you entered is:",
        textAlign = TextAlign.Center,
        color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "RapidFor^TM SARS-CoV-2", color = Purple40, fontSize = 24.sp)
        Text(text = "Rapid Antigen Test", color = Purple40, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f),
            painter = painterResource(
                id = R.drawable.package_picture
            ),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(16.dp),
            text = "If your box belongs to a different kind of test please go back and enter the lot again",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

        ) {
            OutlinedButton(
                border = BorderStroke(1.dp,color = AppColor),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = AppColor,),
                modifier = Modifier
                    .weight(1F)
                    .height(65.dp)
                    .padding(8.dp),
                onClick = { navController.popBackStack() }
            ) {
                Text(text = "Back")
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = AppColor),
                modifier = Modifier
                    .weight(1F)
                    .height(65.dp)
                    .padding(8.dp),
                onClick = {
                navController.navigate(Screen.SymptomScreen.route)
            }) {
                Text(text = "Continue")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewBoxIntroScreen() {
    CovidRapidTestTheme {
        BoxIntroScreen(navController = NavHostController(LocalContext.current))
    }
}