package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.MyTopBar
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import com.covid19.covidrapidtest.ui.theme.Purple40

@Composable
fun LotNumberScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Filled.Close,
                    contentDescription = null,
                tint = Color.White)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Test lot number",
                    color = Color.White,
                    )
            }

        }
        Spacer(modifier = Modifier.padding(40.dp))
        Image(
            painter = painterResource(
                id = R.drawable.image_qr
            ),
            contentDescription = null,
        )
        var text by remember{
            mutableStateOf(TextFieldValue(""))
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Box (contentAlignment = Alignment.TopEnd){
            OutlinedTextField(
                colors = TextFieldDefaults
                    .outlinedTextFieldColors(
                    focusedBorderColor = AppColor,
                    unfocusedBorderColor = AppColor
                    ),
                modifier = Modifier.background(Color.White),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                placeholder = {
                    Text(text = "Enter Lot Number")
                },
                keyboardActions = KeyboardActions{

                }
            )
            IconButton(onClick = {
                navController.navigate(Screen.BoxIntroScreen.route)

            }) {
                Icon(imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                tint = AppColor)
            }
        }

        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            text = "Please enter the lot number written on\n aluminum package",
            textAlign = TextAlign.Center,
            color = Color.White,
            )
        Spacer(modifier = Modifier.padding(18.dp))
        Box(
            modifier = Modifier
                .padding(24.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(AppColor)
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                val context = LocalContext.current
                androidx.compose.material.IconButton(
                    modifier = Modifier
                        .height(75.dp)
                        .width(85.dp),
                    onClick = {
                        //navController.navigate("CameraActivity")
                        // navController.navigate(Screen.CameraActivity.route)
                        //navController.navigate(Screen.QRCodeReaderActivity.route)
                        navController.navigate(Screen.LotNumberScreen.route)
                        //context.startActivity(Intent(context,CameraActivity::class.java))

                    }) {
                    androidx.compose.material.Icon(
                        tint = Color.White,
                        painter = painterResource(
                            id = R.drawable.ic_baseline_qr_code_scanner_24
                        ),
                        contentDescription = null,
                    )

                }
                androidx.compose.material.Text(
                    color = Color.White,
                    text = "Scan QR"
                )
            }
        }



    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLotNumberScreen() {
    CovidRapidTestTheme {
        LotNumberScreen(NavController(LocalContext.current))
    }
}