package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.BoxIntroScreen
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import kotlinx.coroutines.delay

@Composable
fun DisposeScreen(navController: NavController){
    var showSreen by remember{ mutableStateOf(false)}
    LaunchedEffect(key1 = true) {
        delay(6000)
        showSreen = true
    }
    if (!showSreen){
       Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
           CircularProgressIndicator(modifier = Modifier
               .fillMaxWidth(.25f)
               .fillMaxHeight(.25f), color = AppColor, strokeWidth = 8.dp)
       }
    }

    if (showSreen){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(.2f))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f),
            painter = painterResource(
                id = R.drawable.disposal
            ),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Please make sure you dispose the used test kit properly.",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 20.sp
            )
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

        ) {
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = AppColor
            ),
                modifier = Modifier
                    .weight(1F)
                    .height(65.dp)
                    .padding(8.dp),
                onClick = {
                   // PdfShow()
                    navController.navigate(Screen.PdfShowScreen.route)
                }) {
                Text(text = "Continue")
            }

        }

    }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreviewBoxIntroScreen() {
    CovidRapidTestTheme {
        DisposeScreen(navController = NavHostController(LocalContext.current))
    }
}