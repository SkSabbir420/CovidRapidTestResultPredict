package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import android.annotation.SuppressLint
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.common.shareviewmodel.SharedViewModel
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.time.LocalDateTime


data class HorizontalPagerContent(
    val title: String, @DrawableRes val res: Int, val description: String
)

fun getList(): List<HorizontalPagerContent> {
    return listOf(
        HorizontalPagerContent(
            "Step 1",
            R.drawable.step_1,
            "Please read instructions for use (IFU) carefully before the test."
        ),
        HorizontalPagerContent(
            "Step 2",
            R.drawable.step_2,
            "Open the extraction buffer tube and place it into the holder."
        ),
        HorizontalPagerContent(
            "Step 3",
            R.drawable.step_3,
            "Remove the swab from the swab packaging. Caution: the soft tip of the swab should not come into contact with hands or objects."
        ),
        HorizontalPagerContent(
            "Step 4",
            R.drawable.step_4,
            "Put your swap into the tube and rotate the swab 10 times to elute the sample into the buffer."
        ),
        HorizontalPagerContent(
            "Step 5",
            R.drawable.step_5,
            "Break off the upper part of the swab"
        ),
        HorizontalPagerContent(
            "Step 6",
            R.drawable.step_6,
            "Insert the swab 2.5 cm into one nostril and rotate it 6 times."
        ),
        HorizontalPagerContent(
            "Step 7",
            R.drawable.step_7,
            "Close the buffer tube, and gently flip and mix."
        ),
        HorizontalPagerContent(
            "Step 8",
            R.drawable.step_8,
            "Break off the tip of the cap at the selected point."
        ),
        HorizontalPagerContent(
            "Step 9",
            R.drawable.step_9,
            "Open the aluminum package and place the cassette as denoted"
        ),
        HorizontalPagerContent(
            "Step 10",
            R.drawable.step_10,
            "Add 3 drops of sample-extraction buffer mixture to the sample well and read after 15 mins."
        ),
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("HardwareIds")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun StepScreen(navController: NavHostController,sharedViewModel: SharedViewModel) {

    val pagerState = rememberPagerState()
    val list = getList()

    val isNextVisible = remember { derivedStateOf { pagerState.currentPage != list.size - 1 } }
    val isFinishVisible = remember { derivedStateOf { pagerState.currentPage == list.size - 1 } }
    val isPrevVisible = remember { derivedStateOf { pagerState.currentPage != 0 } }

    val scope = rememberCoroutineScope()
    val deviceID = Settings.Secure.getString(LocalContext.current.contentResolver,Settings.Secure.ANDROID_ID)
    val personCollectionRef = Firebase.firestore.collection("covidTestDatabase")
        .document(deviceID).collection("fromFillUp")
    val nodeUniqueKey = Firebase.firestore.collection("covidTestDatabase").document().id

    sharedViewModel.publicFrom.deviceId = deviceID



    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

            HorizontalPager(
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically,
                count = list.size
            ) { currentPage ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.image_logo
                        ),
                        contentDescription = "Image Logo",
                    )
                    Spacer(modifier = Modifier.height(64.dp))
                    AsyncImage(
                        model = list[currentPage].res,
                        contentDescription = null,
                        modifier = Modifier.fillMaxHeight(.5f)
                            .fillMaxWidth()
                    )
                    HorizontalPagerIndicator(
                        pagerState = pagerState, modifier = Modifier
                            .padding(vertical = 26.dp),
                        activeColor = AppColor
                    )
                    Text(
                        text = list[currentPage].title,
                        style = MaterialTheme.typography.h5,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Text(
                        text = list[currentPage].description,
                        style = MaterialTheme.typography.body1,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    modifier = Modifier.fillMaxHeight()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center

                ) {
                    if (isPrevVisible.value) {
                        OutlinedButton(
                            border = BorderStroke(1.dp,color = AppColor),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = AppColor,),
                            modifier = Modifier.weight(1F)
                                .height(65.dp).padding(8.dp),
                            onClick = {
                                scope.launch {
                                    //pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                    pagerState.scrollToPage(pagerState.currentPage - 1)
                                }
                            }
                        ) {
                            androidx.compose.material3.Text(text = "Back")
                        }
                    }else{
                        OutlinedButton(
                            border = BorderStroke(1.dp,color = AppColor),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = AppColor,),
                            modifier = Modifier.weight(1F)
                                .height(65.dp).padding(8.dp),
                            onClick = { navController.popBackStack() }
                        ) {
                            androidx.compose.material3.Text(text = "Back")
                        }

                    }

                    if (isNextVisible.value) {
                        androidx.compose.material3.Button(
                            colors = ButtonDefaults.buttonColors(containerColor = AppColor),
                            modifier = Modifier.weight(1F)
                                .height(65.dp).padding(8.dp),
                            onClick = {
                                scope.launch {
                                    //pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                    pagerState.scrollToPage(pagerState.currentPage + 1)
                                }
                            }) {
                            androidx.compose.material3.Text(text = "Continue")
                        }
                    }
                    if (isFinishVisible.value) {
                        androidx.compose.material3.Button(
                            colors = ButtonDefaults.buttonColors(containerColor = AppColor),
                            modifier = Modifier.weight(1F)
                                .height(65.dp).padding(8.dp),
                            onClick = {

                                val crateTime = LocalDateTime.now().toString()
                                sharedViewModel.publicFrom.createTime = crateTime
                                sharedViewModel.publicFrom.nodeUniqueKey = nodeUniqueKey

                                GlobalScope.launch {
                                    try{
                                        //personCollectionRef.document(crateTime).set(sharedViewModel.publicFrom).await()
                                        personCollectionRef.document(nodeUniqueKey).set(sharedViewModel.publicFrom).await()
                                        withContext(Dispatchers.Main) {
                                            navController.navigate(Screen.TimerScreen.route)
                                            Log.d("StepScreen","Successfully saved data.")
                                        }
                                    }catch (e:Exception){
                                        Log.d("StepScreen","$e")
                                    }

                                }
                                //navController.navigate(Screen.TimerScreen.route)
                            }) {
                            androidx.compose.material3.Text(text = "Finish")
                        }
                    }


                }
            }

    }
}

//private fun savePerson(person: Person) = CoroutineScope(Dispatchers.IO).launch {
//    try {
//        personCollectionRef.set(person).await()
//        withContext(Dispatchers.Main) {
//            Toast.makeText(this@MainActivity, "Successfully saved data.", Toast.LENGTH_LONG).show()
//        }
//    } catch(e: Exception) {
//        withContext(Dispatchers.Main) {
//            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
//        }
//    }
//}
//private fun retrievePersons()= CoroutineScope(Dispatchers.IO).launch {
//    try {
//        val querySnapshot =  personCollectionRef.get().await()
//        val sb = StringBuilder()
//        Log.d("MainActivity",querySnapshot.toString())
//
//    }catch (e:Exception){
//        Log.d("MainActivity",e.toString())
//    }
//}



