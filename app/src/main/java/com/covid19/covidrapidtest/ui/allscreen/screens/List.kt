package com.covid19.covidrapidtest.ui.allscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.list_sub_screen.allResultShowfeature.FinalResultShowFeature
import com.covid19.covidrapidtest.ui.navigation.Screen

@Composable
fun ListScreen(navController:NavController) {
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
            //AllResultSeeScreen(navController)
            FinalResultShowFeature(navController)
        }
    )
}

@Composable
@Preview
fun ProfileScreenPreview() {
    //ListScreen()
}