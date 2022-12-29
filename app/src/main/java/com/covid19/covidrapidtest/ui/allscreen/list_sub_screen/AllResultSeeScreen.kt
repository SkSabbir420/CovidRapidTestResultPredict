package com.covid19.covidrapidtest.ui.allscreen.list_sub_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.TestList

@Composable
fun AllResultSeeScreen(navController: NavController){
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "On GoingTest Screen")
//    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        TestListSee(navController)
        TestListSee(navController)
    }
}