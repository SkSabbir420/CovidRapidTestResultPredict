
package com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.common.shareviewmodel.SharedViewModel
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.utils.Utility
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.utils.Utility.formatTime
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.view.components.CountDownButton
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.view.components.CountDownIndicator
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.view.components.ShowCelebration
import com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.viewmodel.MainViewModel

@Composable
fun CountDownView(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),sharedViewModel: SharedViewModel) {

    val time by viewModel.time.observeAsState(Utility.TIME_COUNTDOWN.formatTime())
    val progress by viewModel.progress.observeAsState(1.00F)
    val isPlaying by viewModel.isPlaying.observeAsState(false)
    val celebrate by viewModel.celebrate.observeAsState(false)

    CountDownView(time = time, progress = progress, isPlaying = isPlaying, celebrate = celebrate, name = sharedViewModel.publicFrom.nameValue) {
        viewModel.handleCountDownTimer()
    }
}

@Composable
fun CountDownView(
    time: String,
    name:String,
    progress: Float,
    isPlaying: Boolean,
    celebrate: Boolean,
    optionSelected: () -> Unit,

) {
    var start by  remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if (celebrate) {
            ShowCelebration()
        }

        Text(
            text = "\"$name\" cassette result is ready to be sent in",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            fontFamily = FontFamily(Font(R.font.poppins_semibold))

        )

//        Text(
//            text = "1 minute to launch...",
//            color = androidx.compose.ui.graphics.Color.White,
//            fontSize = 16.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(20.dp),
//            fontFamily = FontFamily(Font(R.font.poppins_semibold))
//        )

//        Text(
//            text = "Click to start or stop countdown",
//            color = androidx.compose.ui.graphics.Color.White,
//            fontSize = 14.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth(),
//            fontFamily = FontFamily(Font(R.font.poppins_regular))
//        )

        CountDownIndicator(
            Modifier.padding(top = 50.dp),
            progress = progress,
            time = time,
            size = 250,
            stroke = 16
        )

//        CountDownButton(
//
//            modifier = Modifier
//                .padding(top = 70.dp)
//                .size(70.dp),
//            isPlaying = isPlaying
//        ) {
//            optionSelected()
//        }
        if (!start){
            start=true
            optionSelected()
        }
    }
}
