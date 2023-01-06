package com.covid19.covidrapidtest.ui.allscreen.pdf_screen

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
import com.covid19.covidrapidtest.ui.allscreen.common.fromobject.SymptomFrom
import com.covid19.covidrapidtest.ui.allscreen.list_sub_screen.TestListSee
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.TestList
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.sealed.DataState
import com.covid19.covidrapidtest.ui.theme.AppColor


@Composable
fun FinalResultShowInPdf(navController: NavController,key:String,dataPass:(OngoingSymptomFrom)->Unit){

    val viewModel = FinalResultShowInPdfViewModel(LocalContext.current, key)
    Column {
        SetData(viewModel,navController,dataPass)
    }

}

@Composable
fun SetData(viewModel: FinalResultShowInPdfViewModel,navController: NavController,dataPass2:(OngoingSymptomFrom)->Unit) {
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
            ShowLazyList(result.data,navController,dataPass2)
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
fun ShowLazyList(SymptomFromDatas: MutableList<OngoingSymptomFrom>,navController: NavController,dataPass3: (OngoingSymptomFrom) -> Unit) {
//    LazyColumn {
//        items(SymptomFromDatas) { symptomFromData ->
//            //TestListSee(SymptomFromData = symptomFromData, navController = navController)
//            PdfContentScreen(symptomFromData)
//        }
//    }

    if (SymptomFromDatas.size > 0 ){
        dataPass3(SymptomFromDatas.first())
        PdfContentScreen(SymptomFromDatas.first())


    }


}

