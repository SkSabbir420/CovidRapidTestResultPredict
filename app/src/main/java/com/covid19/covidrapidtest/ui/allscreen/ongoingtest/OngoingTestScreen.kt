package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OngoingTestScreen(){

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        TestList()
        TestList()
        TestList()
        TestList()
        TestList()
    }
}