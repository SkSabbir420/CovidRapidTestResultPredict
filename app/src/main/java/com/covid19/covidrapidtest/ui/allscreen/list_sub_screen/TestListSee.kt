package com.covid19.covidrapidtest.ui.allscreen.list_sub_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDate
import java.time.Period

@Composable
fun TestListSee(navController: NavController, symptomFromData: OngoingSymptomFrom){


    Card(
        modifier = Modifier.padding(16.dp),
        //,
        elevation = 12.dp
    ){
       Row(
           modifier = Modifier
               .fillMaxWidth()
               //.clip(RoundedCornerShape(12.dp))
               .padding(8.dp)
               //.background(Color.LightGray)
           ,
           verticalAlignment = Alignment.CenterVertically

       ) {
           Row(modifier = Modifier.fillMaxWidth(.3f)){
               Column(modifier = Modifier
                   .fillMaxWidth()
                   .padding(4.dp)
                   , verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text(text = "${symptomFromData.nameValue} Test", color = AppColor)
                   Text(text = "${symptomFromData.sexValue} - ${Period.between(LocalDate
                       .of(symptomFromData.birthValue.toInt(), 1, 1), LocalDate.now())
                       .years} years old",color = Color.Black, fontSize = 10.sp)
               }

           }
           Row(modifier = Modifier.fillMaxWidth(.3f)){
               Column(modifier = Modifier
                   .fillMaxWidth()
                   .padding(4.dp)
               , verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text(text = "Date", color = AppColor)
                   Text(text = "${symptomFromData.createTime.subSequence(0,10)}",color = Color.Black, fontSize = 10.sp)
               }

           }
           Row(modifier = Modifier.fillMaxWidth(.7f),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Center

           ){
               Button(modifier = Modifier.padding(4.dp),
                   colors = ButtonDefaults.buttonColors(
                       containerColor = Green
                   ),
                   onClick = {
                       // context.startActivity(Intent(context,TestCaptureActivity::class.java))
                       navController.navigate("${Screen.PdfShowScreen.route}/${symptomFromData.nodeUniqueKey}")
                   }
               ) {
                   Text(text = "review", color = Color.White)
               }
           }
           IconButton(onClick = {
               FirebaseFirestore.getInstance().collection("covidTestDatabase")
                   .document(symptomFromData.deviceId).collection("finalTestResult")
                   .document(symptomFromData.nodeUniqueKey).delete()

           }) {
               Icon(
                   tint = Color.Black,
                   modifier = Modifier,
                   imageVector = Icons.Outlined.Delete,
                   contentDescription =""
               )
           }


       }
    }
}

@Preview
@Composable
fun PreviewTestList(){
    //TestListSee(navController = NavHostController(LocalContext.current))
}