package com.covid19.covidrapidtest.ui.allscreen.list_sub_screen.allResultShowfeature

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
import androidx.navigation.NavController
import com.covid19.covidrapidtest.ui.allscreen.list_sub_screen.TestListSee
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.sealed.DataState


@Composable
fun FinalResultShowFeature(navController: NavController){

    val viewModel = FinalResultShowFeatureViewModel(LocalContext.current)
    Column {
        SetData(viewModel,navController)
    }

}

@Composable
fun SetData(viewModel: FinalResultShowFeatureViewModel,navController: NavController) {
    when (val result = viewModel.response.value) {
        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is DataState.Success -> {
            ShowLazyList(result.data,navController)
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
fun ShowLazyList(SymptomFromDatas: MutableList<OngoingSymptomFrom>,navController: NavController) {
    LazyColumn {
        items(SymptomFromDatas) { symptomFromData ->
            TestListSee(symptomFromData = symptomFromData, navController = navController)
            if (symptomFromData == SymptomFromDatas[SymptomFromDatas.size-1] ){
                Spacer(modifier = Modifier.height(80.dp))
            }

        }
    }
}

