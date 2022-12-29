package com.covid19.covidrapidtest.ui.allscreen.list_sub_screen

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.covid19.covidrapidtest.ui.theme.Purple80

@Composable
fun TestListSee(navController: NavController){
    Card(
        modifier = Modifier.padding(16.dp),
        //,
        elevation = 16.dp
    ){
       Row(
           modifier = Modifier
               .fillMaxWidth()
               //.clip(RoundedCornerShape(12.dp))
               //.padding(20.dp)
               //.background(Color.LightGray)
           ,
           verticalAlignment = Alignment.CenterVertically

       ) {
                val context = LocalContext.current
                Text(text = "Name Test", modifier = Modifier.padding(16.dp), color = AppColor)
                Text(text = "Date", modifier = Modifier.padding(16.dp), color = AppColor)
                Spacer(modifier = Modifier.weight(1.0f))
                Button(colors = ButtonDefaults.buttonColors(
                    containerColor = Green
                ),
                    onClick = {
                        // context.startActivity(Intent(context,TestCaptureActivity::class.java))
                        navController.navigate(Screen.PdfShowScreen.route)
                    }
                ) {
                    Text(text = "review", color = Color.White)
                }
                Icon(
                    tint = Color.Black,
                    modifier = Modifier.padding(16.dp),
                    imageVector = Icons.Outlined.Delete,
                    contentDescription =""
                )
            
        }
    }
}

@Preview
@Composable
fun PreviewTestList(){
    TestListSee(navController = NavHostController(LocalContext.current))
}