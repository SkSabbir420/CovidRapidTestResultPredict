package com.covid19.covidrapidtest.ui.allscreen.list_sub_screen.allResultShowfeature

import android.content.Context
import android.provider.Settings
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.sealed.DataState
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User

class FinalResultShowFeatureViewModel(context:Context) : ViewModel() {

    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchDataFromFirebase(context)
    }

    private fun fetchDataFromFirebase(context: Context) {
        val tempList = mutableListOf<OngoingSymptomFrom>()
        response.value = DataState.Loading

        val deviceID = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        FirebaseFirestore.getInstance().collection("covidTestDatabase")
            .document(deviceID).collection("finalTestResult")
            .get()
            .addOnSuccessListener {
                if(!it.isEmpty){
                    for (data in it.documents){
                        val uer:OngoingSymptomFrom? = data.toObject(OngoingSymptomFrom::class.java)
                        if (uer != null){
                            tempList.add(uer)
                        }
                    }
                    response.value = DataState.Success(tempList)
                }

            }
            .addOnFailureListener {
                Log.d("RetriveData",it.toString())

            }


    }
}