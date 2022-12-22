package com.covid19.covidrapidtest.ui.allscreen.home_sub_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.covid19.covidrapidtest.R

@Composable
fun ActionButtonScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
//                actions = {
//                    IconButton(onClick = {  }) {
//                        //Icon(imageVector = R.drawable.ic_baseline_account_tree_24, contentDescription ="" )
//                        Image(
//                            painter = painterResource(
//                                id = R.drawable.ic_baseline_account_tree_24
//                            ),
//                            contentDescription = null,
//                        )
//                    }
//                },
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
                Text(text = "Action Button Screen")
            }
        }
    )

}