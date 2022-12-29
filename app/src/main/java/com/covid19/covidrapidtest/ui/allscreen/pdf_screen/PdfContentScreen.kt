package com.covid19.covidrapidtest.ui.allscreen.pdf_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.covid19.covidrapidtest.ui.theme.AppColor

@Composable
fun PdfContentScreen(){
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 16.dp
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Negative", color = AppColor, fontSize = 16.sp)
                    Text(text = "16.12.2022 - 4:45 PM")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Our tests provide high accuracy however, you could not be sure totally. The virus load in your body could not be significant enough that the test detects, so you should have another test after 4-5 days. Do not forget maintain social distancing and avoid risky areas.")

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "P.S This result is evaluated by Artificial Intelligence.", color = Color.Red)
            Text(text = "It is just for informational purposes, no certificate and health pass value.", color = Color.Red,)

            Spacer(modifier = Modifier.height(8.dp))

            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Full Name")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "Sabbir")
            }

            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Age")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "0")
            }

            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Gender")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "Male")
            }

            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Product")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "RapidFor SARS-CoV-2 Rapid Antigen Test")
            }

            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "LOT")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "S0221101701")
            }

            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Manufacturer")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "Vitrosens Biotechnology Ltd.Sti.")
            }

            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Test Number")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "bwxdzStx")
            }

            Divider(modifier = Modifier.fillMaxWidth())


        }
        
    }
}