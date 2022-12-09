package com.covid19.covidrapidtest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import com.covid19.covidrapidtest.ui.theme.Purple40

@Composable
fun MainScreen(navController: NavController) {
    var bottomState by remember { mutableStateOf("Home") }

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
                                    context.startActivity(Intent(context,CameraActivity::class.java))

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
                                onClick = { }) {
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
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                contentColor = Color.Black
            ){
                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { bottomState = "Home" },
//                    label = { Text(text = "Home")},
                    icon = {
                        Icon(imageVector = Icons.Default.Home,
                            contentDescription = null)
                    },
                    selectedContentColor = if (bottomState=="Home") Purple40 else Color.Black
                )
                BottomNavigationItem(
                    selected = bottomState == "List",
                    onClick = { bottomState = "List" },
                    //label = { Text(text = "List")},
                    icon = {
                        Icon(imageVector = Icons.Default.List,
                            contentDescription = null)
                    },
                    selectedContentColor = if (bottomState=="List") Purple40 else Color.Black
                )
            }
        }

    )
}

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainScreen"){

        composable( route= "MainScreen"){
            MainScreen(navController = navController)
        }
        composable( route= "CameraActivity"){
            CameraActivity(navController = navController)
        }
        composable(route= "RetakePictureActivity"){
            RetakePictureActivity(navController = navController)
        }
        composable(route= "ResultShowActivity"){
            ResultShowActivity()
        }
    }
}


@Composable
fun CameraActivity(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to Camera Activity")
        Button(
            onClick = {
                navController.navigate("RetakePictureActivity")
            }
        ) {
            Text(text = "Capture")
        }
    }
}

@Composable
fun RetakePictureActivity(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "RetakePictureActivity")
        Button(
            onClick = {
                navController.navigate("ResultShowActivity")
            }
        ) {
            Text(text = "Continue")
        }
    }
}
@Composable
fun ResultShowActivity(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "ResultShowActivity")
    }
}