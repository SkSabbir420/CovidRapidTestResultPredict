package com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.TestList
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.sealed.DataState
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.viewmodels.OngoingSyntromShowViewModel
import com.covid19.covidrapidtest.ui.theme.AppColor
import java.time.LocalDateTime


@Composable
fun OngoingSymptomShow(){

    val viewModel = OngoingSyntromShowViewModel(LocalContext.current)
    Column {
        SetData(viewModel)
    }

}

@Composable
fun SetData(viewModel: OngoingSyntromShowViewModel) {
    when (val result = viewModel.response.value) {
        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(modifier = Modifier
                    .fillMaxWidth(.25f)
                    .fillMaxHeight(.25f), color = AppColor, strokeWidth = 8.dp)
            }
        }
        is DataState.Success -> {
            ShowLazyList(result.data)
        }
        is DataState.Failure -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = result.message,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                )
            }
        }
        is DataState.Empty -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "You don't have any ongoing test.",
                    fontSize = MaterialTheme.typography.h5.fontSize,
                )
            }
        }
        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error Fetching data",
                    fontSize = MaterialTheme.typography.h5.fontSize,
                )
            }
        }
    }
}

@Composable
fun ShowLazyList(SymptomFromDatas: MutableList<OngoingSymptomFrom>) {
    LazyColumn {
        items(SymptomFromDatas) { symptomFromData ->

            TestList(symptomFromData = symptomFromData)
            if (symptomFromData == SymptomFromDatas[SymptomFromDatas.size-1] ){
                Spacer(modifier = Modifier.height(80.dp))
            }

//            val currentTimeMinus15 = LocalDateTime.now().minusMinutes(15)
//            val fromCreateTime = LocalDateTime.parse(symptomFromData.createTime)
//            if(fromCreateTime.isBefore(currentTimeMinus15)){
//                TestList(SymptomFromData = symptomFromData)
//            }

        }
    }
}

