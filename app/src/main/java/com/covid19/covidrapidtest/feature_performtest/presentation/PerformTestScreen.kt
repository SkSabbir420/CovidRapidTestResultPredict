package com.covid19.covidrapidtest.feature_performtest.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import  com.covid19.covidrapidtest.R

@Composable
fun PerformTestScreen(){
    val viewModel: PerformTestScreenViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
           Image(
               painter = painterResource(
                   id = R.drawable.image_logo
               ),
               contentDescription = "Image Logo",
               modifier = Modifier.weight(.9f)
           )
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    painter = painterResource(
                    id = R.drawable.ic_baseline_account_tree_24
                ),
                    contentDescription = "Navigation Top")
            }
            
        }
        Spacer(modifier = Modifier
            .padding(bottom = 8.dp)
        )


    }

}