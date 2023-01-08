package com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.sealed

import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom

sealed class DataState {
    class Success(val data: MutableList<OngoingSymptomFrom>) : DataState()
    class Failure(val message: String) : DataState()
    object Loading : DataState()
    object NotFound : DataState()
    object Empty : DataState()
}