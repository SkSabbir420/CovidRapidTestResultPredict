package com.covid19.covidrapidtest.ui.allscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.Purple40
import com.covid19.covidrapidtest.R

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
                    IconButton(onClick = {  }) {
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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(.5f)
                        .fillMaxWidth(.5f)
                        .background(Purple40),
                    contentAlignment = Alignment.Center,
                ) {
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
                        .fillMaxHeight(.3f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ){
                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .background(Purple40)
                    ) {
                        Column {
                            val context = LocalContext.current
                            IconButton(
                                modifier = Modifier
                                    .height(64.dp)
                                    .width(64.dp),
                                onClick = {
                                    //navController.navigate("CameraActivity")
                                    navController.navigate(Screen.CameraActivity.route)
                                    //context.startActivity(Intent(context,CameraActivity::class.java))

                                }) {
                                Icon(
                                    painter = painterResource(
                                        id = R.drawable.ic_baseline_qr_code_scanner_24
                                    ),
                                    contentDescription = null,
                                )
                            }
                        }
                    }

                    Box(modifier = Modifier
                        .padding(24.dp)
                        .background(Purple40)
                    ){
                        Column {
                            IconButton(modifier = Modifier
                                .height(64.dp)
                                .width(64.dp),
                                onClick = {
                                    navController.navigate(Screen.CameraActivity.route)
                                }) {
                                Icon(
                                    painter = painterResource(
                                        id = R.drawable.ic_baseline_list_alt_24
                                    ),
                                    contentDescription = null,
                                )
                            }
                        }
                    }


                }



            }

        },
    )
}

//@Composable
//@Preview
//fun HomeScreenPreview() {
//    HomeScreen()
//}