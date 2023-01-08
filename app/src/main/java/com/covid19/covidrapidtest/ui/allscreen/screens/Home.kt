package com.covid19.covidrapidtest.ui.allscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.Purple40
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.theme.AppColor

@Composable
fun HomeScreen(navController : NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.image_logo
                            ),
                            contentDescription = "Image Logo",
                        )
                    }

                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.ActionButtonScreen.route)
                    }) {
                        //Icon(imageVector = R.drawable.ic_baseline_account_tree_24, contentDescription ="" )
                        Image(
                            painter = painterResource(
                                id = R.drawable.ic_baseline_account_tree_24
                            ),
                            contentDescription = null,
                        )
                    }
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },

        content = {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight(.64f)
                        .fillMaxWidth(.75f)
                        .clip(RoundedCornerShape(32.dp))
                        .background(Purple40),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        color = Color.White,
                        fontSize = 18.sp,
                        text = "RapidFor^TM SARS-CoV-2",

                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                        color = Color.White,
                        fontSize = 18.sp,
                        text = "Rapid Antigen Test",

                        )
                    Image(
                        painter = painterResource(
                            id = R.drawable.slider_picture
                        ),
                        contentDescription = "Image Logo",
                        modifier = Modifier
                            .fillMaxHeight(.6f)
                            .fillMaxWidth(.2f)
                    )
                }


                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.8f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .height(110.dp)
                            .width(110.dp)
                            .background(Color.Black)
                            .clickable {
                                //navController.popBackStack()
                                navController.navigate(Screen.QRCodeReaderActivity.route)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
//                            val context = LocalContext.current
//                            IconButton(
//                                modifier = Modifier
//                                    .height(80.dp)
//                                    .width(80.dp)
//                                ,
//                                onClick = {
//                                    //navController.navigate("CameraActivity")
//                                   // navController.navigate(Screen.CameraActivity.route)
//                                    //navController.popBackStack()
//
//                                    navController.navigate(Screen.QRCodeReaderActivity.route)
//
//                                    //navController.navigate(Screen.LotNumberScreen.route)
//                                    //context.startActivity(Intent(context,CameraActivity::class.java))
//
//                                }) {
                                Icon(
                                    tint = Color.White,
                                    painter = painterResource(
                                        id = R.drawable.ic_baseline_qr_code_scanner_24

                                    ),
                                    contentDescription = null,
                                )
                                
                            //}
                            Text(
                                color = Color.White,
                                text = "Perform  Tests"
                            )
                        }
                    }

                    Box(modifier = Modifier
                        .padding(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .height(110.dp)
                        .width(110.dp)
                        .background(AppColor)
                        .clickable {
                            navController.navigate(Screen.OnGoingTest.route)
                        },
                        contentAlignment = Alignment.Center
                    ){
                        Column (
                            modifier = Modifier.padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
//                            IconButton(modifier = Modifier
//                                .height(80.dp)
//                                .width(80.dp),
//                                onClick = {
//                                   // navController.navigate(Screen.OnGoingTest.route)
//                                }) {
                                Icon(
                                    tint = Color.White,
                                    painter = painterResource(
                                        id = R.drawable.ic_baseline_list_alt_24
                                    ),
                                    contentDescription = null,
                                )
                           // }
                            Text(
                                color = Color.White,
                                text = "Ongoing Tests"
                            )
                        }
                    }


                }



            }

        },
    )
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(NavController(LocalContext.current))
}