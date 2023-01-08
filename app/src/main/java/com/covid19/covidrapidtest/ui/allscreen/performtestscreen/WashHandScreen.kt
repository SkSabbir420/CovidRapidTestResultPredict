package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.AppColor

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
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth()
            ,
            painter = painterResource(
                id = R.drawable.hand_wash
            ),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Wash your hands now",
            fontSize = 22.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "You are about to enter to the test process.\nPlease make sure you wash your hand and have your test kit ready with you.",
            fontSize = 14.sp, textAlign = TextAlign.Center)

        Row(
            modifier = Modifier.fillMaxHeight()
                .padding(16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

        ) {
            OutlinedButton(
                border = BorderStroke(1.dp,color = AppColor),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = AppColor,),
                modifier = Modifier.weight(1F)
                    .height(65.dp).padding(8.dp),
                onClick = { navController.popBackStack() }
            ) {
                Text(text = "Back")
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = AppColor),
                modifier = Modifier.weight(1F)
                    .height(65.dp).padding(8.dp),
                onClick = {
                    navController.navigate(Screen.BoxContentScreen.route)
                }) {
                Text(text = "Continue")
            }

        }

    }
}