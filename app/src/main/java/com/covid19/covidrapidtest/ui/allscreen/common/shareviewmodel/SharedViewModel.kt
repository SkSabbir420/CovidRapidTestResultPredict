package com.covid19.covidrapidtest.ui.allscreen.common.shareviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.fromobject.SymptomFrom

class SharedViewModel:ViewModel() {
    //var symptomFrom by mutableStateOf<SymptomFrom?>(null)
        //private set

    var publicFrom = SymptomFrom()

//    fun addSymptomFrom(newFrom: SymptomFrom){
//        symptomFrom = newFrom
//    }
}