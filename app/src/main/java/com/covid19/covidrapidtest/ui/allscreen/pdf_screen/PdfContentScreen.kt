package com.covid19.covidrapidtest.ui.allscreen.pdf_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.theme.AppColor

@Composable
fun PdfContentScreen(symptomFromData: OngoingSymptomFrom) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = 16.dp
        ) {
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
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = symptomFromData.testResult, color = AppColor, fontSize = 16.sp)
                        //Text(text = "16.12.2022 - 4:45 PM")
                        Text(text = symptomFromData.createTime)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                if (symptomFromData.testResult == "Negative") {
                    Text(text = "Our tests provide high accuracy however, you could not be sure totally. The virus load in your body could not be significant enough that the test detects, so you should have another test after 4-5 days. Do not forget maintain social distancing and avoid risky areas.")
                }else {
                    Text(text = "Get in touch with your healthcare provider and inform your situation. You should make further confirmation of COVID-19 infection by getting a polymerase chain reaction (PCR Test). If the infection is verified, you should isolate yourself and also follow the public health protocols of your local area.")
                }
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "P.S This result is evaluated by Artificial Intelligence.",
                    color = Color.Red
                )
                Text(
                    text = "It is just for informational purposes, no certificate and health pass value.",
                    color = Color.Red,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.fillMaxWidth(.4f)){
                        Text(text = "Full Name")
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Text(text = symptomFromData.nameValue)
                    }

                }

                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.fillMaxWidth(.4f)){
                        Text(text = "Birth")
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Text(text = symptomFromData.birthValue)
                    }
                }

                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.fillMaxWidth(.4f)){
                        Text(text = "Gender")
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Text(text = symptomFromData.sexValue)
                    }

                }

                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.fillMaxWidth(.4f)){
                        Text(text = "Product")
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Text(text = "RapidFor SARS-CoV-2 Rapid Antigen Test")
                    }

                }

                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.fillMaxWidth(.4f)){
                        Text(text = "LOT")
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        //Text(text = "S0221101701")
                        Text(text = symptomFromData.lotNumber)
                    }

                }

                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.fillMaxWidth(.4f)){
                        Text(text = "Manufacturer")
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Text(text = "Vitrosens Biotechnology Ltd.Sti.")
                    }

                }

                Divider(modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.fillMaxWidth(.4f)){
                        Text(text = "Test Number")
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        //Text(text = "bwxdzStx")
                        Text(text = symptomFromData.nodeUniqueKey)
                    }
                }

                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "QR Code of Unique Test")
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(.5f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            painter = painterResource(
                                id = R.drawable.image_qr
                            ),
                            contentDescription = null,
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
//                        Image(
//                            modifier = Modifier
//                                .width(60.dp)
//                                .height(60.dp),
//                            painter = painterResource(
//                                id = R.drawable.negative_result
//                            ),
//                            contentDescription = null,
//                        )
                        Image(painter = rememberImagePainter(data =symptomFromData.testResultImageUrl ),
                            contentDescription = null,
                            modifier = Modifier.width(60.dp).height(60.dp),
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Button(enabled = false,
                        colors = ButtonDefaults.buttonColors(containerColor = AppColor),
                        modifier = Modifier.padding(8.dp),
                        onClick = {
                            //navController.navigate(Screen.StepScreen.route)
                        }) {
                        androidx.compose.material3.Text(text = "give feedback")
                    }

                }


            }

        }
    }
}