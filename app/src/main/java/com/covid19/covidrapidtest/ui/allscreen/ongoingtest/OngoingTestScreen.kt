package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.covid19.covidrapidtest.ui.allscreen.list_sub_screen.TestListSee

@Composable
fun OngoingTestScreen(){

//    Column(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        Spacer(modifier = Modifier.height(48.dp))
//
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(24.dp))
        TestList()
        TestList()
        TestList()
        TestList()
        TestList()
        TestList()
        TestList()
        TestList()
        TestList()
        TestList()
        Spacer(modifier = Modifier.height(80.dp))
    }
}