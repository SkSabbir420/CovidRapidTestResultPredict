package com.covid19.covidrapidtest.ui.allscreen.list_sub_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.TestList

@Composable
fun AllResultSeeScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(24.dp))
        TestListSee(navController)
        TestListSee(navController)
        TestListSee(navController)
        TestListSee(navController)
        TestListSee(navController)
        TestListSee(navController)
        TestListSee(navController)
        TestListSee(navController)
        Spacer(modifier = Modifier.height(80.dp))
    }
}