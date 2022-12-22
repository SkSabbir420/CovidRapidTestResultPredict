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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen
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
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "You are now about to start the process.")
        Text(text = "The test you entered is:")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "RapidFor^TM SARS-CoV-2", color = Purple40, fontSize = 24.sp)
        Text(text = "Rapid Antigen Test", color = Purple40, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(
                id = R.drawable.package_picture
            ),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "If your box belongs to a different kind of test please go back and enter the lot again",
            fontSize = 12.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Back")
            }
            Button(onClick = {
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
    }
}