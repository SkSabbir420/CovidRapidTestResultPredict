package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.MyTopBar
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme

@Composable
fun LotNumberScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Close,
                    contentDescription = null)
            }
            Text(
                text = "Test lot number"
            )
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
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                keyboardActions = KeyboardActions{

                }
            )
            IconButton(onClick = {
                navController.navigate(Screen.BoxIntroScreen.route)

            }) {
                Icon(imageVector = Icons.Filled.Done,
                    contentDescription = null)
            }
        }

        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            text = "Please enter the lot number written on\n aluminum package"
        )
        Spacer(modifier = Modifier.padding(18.dp))
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(
                        id = R.drawable.ic_baseline_qr_code_scanner_24
                ),
                contentDescription = null,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )
        }



    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLotNumberScreen() {
    CovidRapidTestTheme {
        //LotNumberScreen()
    }
}