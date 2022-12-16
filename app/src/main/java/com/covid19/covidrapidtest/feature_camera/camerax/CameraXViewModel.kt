package com.covid19.covidrapidtest.feature_camera.camerax

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CameraXViewModel(bitmap: Bitmap):ViewModel() {

    private var _imageBitmap = mutableStateOf(bitmap)
    val imageBitmap = _imageBitmap
}