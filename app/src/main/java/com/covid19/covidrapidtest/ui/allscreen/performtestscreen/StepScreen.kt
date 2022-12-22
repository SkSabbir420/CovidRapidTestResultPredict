package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.Screen


data class HorizontalPagerContent(
    val title: String, @DrawableRes val res: Int, val description: String
)

fun getList(): List<HorizontalPagerContent> {
    return listOf(
        HorizontalPagerContent(
            "Step 1",
            R.drawable.first,
            "Please read instructions for use (IFU) carefully before the test."
        ),
        HorizontalPagerContent(
            "Step 2",
            R.drawable.first,
            "Open the extraction buffer tube and place it into the holder."
        ),
        HorizontalPagerContent(
            "Step 3",
            R.drawable.first,
            "Remove the swab from the swab packaging. Caution: the soft tip of the swab should not come into contact with hands or objects."
        ),
        HorizontalPagerContent(
            "Step 4",
            R.drawable.first,
            "Put your swap into the tube and rotate the swab 10 times to elute the sample into the buffer."
        ),
        HorizontalPagerContent(
            "Step 5",
            R.drawable.first,
            "Break off the upper part of the swab"
        ),
        HorizontalPagerContent(
            "Step 6",
            R.drawable.first,
            "Insert the swab 2.5 cm into one nostril and rotate it 6 times."
        ),
        HorizontalPagerContent(
            "Step 7",
            R.drawable.first,
            "Close the buffer tube, and gently flip and mix."
        ),
        HorizontalPagerContent(
            "Step 8",
            R.drawable.first,
            "Break off the tip of the cap at the selected point."
        ),
        HorizontalPagerContent(
            "Step 9",
            R.drawable.first,
            "Open the aluminum package and place the cassette as denoted"
        ),
        HorizontalPagerContent(
            "Step 10",
            R.drawable.first,
            "Add 3 drops of sample-extraction buffer mixture to the sample well and read after 15 mins."
        ),
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StepScreen(navController: NavHostController) {

    val pagerState = rememberPagerState()
    val list = getList()

    val isNextVisible = remember { derivedStateOf { pagerState.currentPage != list.size - 1 } }
    val isFinishVisible = remember { derivedStateOf { pagerState.currentPage == list.size - 1 } }
    val isPrevVisible = remember { derivedStateOf { pagerState.currentPage != 0 } }

    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.75f)
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

                    Text(
                        text = list[currentPage].title,
                        style = MaterialTheme.typography.h4,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    AsyncImage(
                        model = list[currentPage].res,
                        contentDescription = null, modifier = Modifier
                            .height(380.dp)
                            .width(300.dp)
                    )

                    Text(
                        text = list[currentPage].description,
                        style = MaterialTheme.typography.body1,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth(.6f)
                            .align(
                                Alignment.CenterHorizontally
                            )
                    )
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState, modifier = Modifier
                .padding(vertical = 26.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            if (isPrevVisible.value) {
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }) {
                    Text(text = "Prev")
                }
            }
            if (isPrevVisible.value && isNextVisible.value) {
                Box(modifier = Modifier.fillMaxWidth(.2f))
            }

            if (isNextVisible.value) {
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }) {
                    Text(text = "Next")
                }
            }

            if (isNextVisible.value) {
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }) {
                    Text(text = "Next")
                }
            }
            if (isFinishVisible.value) {
                Button(onClick = {
                    navController.navigate(Screen.TimerScreen.route)
                }) {
                    Text(text = "Finish")
                }
            }

        }

    }
}
