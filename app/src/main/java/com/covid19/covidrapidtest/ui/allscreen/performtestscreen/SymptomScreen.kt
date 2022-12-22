package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun SymptomScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(
                                id = com.covid19.covidrapidtest.R.drawable.image_logo
                            ),
                            contentDescription = "Image Logo",
                        )
                    }

                },
//                navigationIcon = if (navController.previousBackStackEntry != null) {
//                    {
//                        IconButton(onClick = { navController.navigateUp() }) {
//                            Icon(
//                                imageVector = Icons.Filled.ArrowBack,
//                                contentDescription = "Back"
//                            )
//                        }
//                    }
//                } else {
//                    null
//                }
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },

        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Please enter your full name")
                OutlinedTextField(value = "", onValueChange = {})
                Text(text = "Please Select your birth year and sex")
                Row(modifier = Modifier.fillMaxWidth()) {
                    val suggestions = listOf("2022","2021","2020","2019")
                    DropDownButton("birth year",suggestions)
                    val suggestions2 = listOf("Female", "Male")
                    DropDownButton("sex",suggestions2)
                }
                Text(text = "Do you have any symptom? Please check your symptoms")
                Symptoms()
                Text(text = "Do you get vaccinated? Please select your vaccination details")
                Column {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        val suggestions2 = listOf("Female", "Male")
                        DropDownButton("sex",suggestions2)
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        val suggestions2 = listOf("Female", "Male")
                        DropDownButton("sex",suggestions2)
                    }
                }
                Text(text = "Add another type of vaccine")


            }
        },

        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = Color(0xFF018786),
                onClick = {
                    navController.navigate(Screen.WashHandScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Froward"
                )
            }
        },
    )
}

@Composable
fun DropDownButton(showText:String, suggestions : List<String>){
    var expanded by remember { mutableStateOf(false) }
    OutlinedButton(onClick = { expanded = !expanded }){
        Text (showText)
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = null,
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
    ) {
        suggestions.forEach { label ->
            DropdownMenuItem(onClick = {
                expanded = false
                //do something ...
            }) {
                Text(text = label)
            }
        }
    }
}

@Composable
fun Symptoms(){
    FlowRow(
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 10.dp,
        modifier = Modifier.fillMaxWidth()
    ){
        SymptomShow("headache")
        SymptomShow("aching muscles")
        SymptomShow("shortness of breath")
        SymptomShow("diarrhea")
        SymptomShow("fatigue")
        SymptomShow("fever or chills")
        SymptomShow("sore throat")
        SymptomShow("loss of taste and smell")
        SymptomShow("cough")
        SymptomShow("running nose")
        SymptomShow("sneezing")
        SymptomShow("no symptom")
    }
}


@Composable
fun SymptomShow(symptom:String){
    var buttonValue by remember{ mutableStateOf(false) }
    if(buttonValue){
        Button(onClick = {
            buttonValue = false
        }) {
            Text(text = symptom)
        }
    }else{
        OutlinedButton(
            //modifier = Modifier.clip(),
            onClick = {
                buttonValue = true
            }
        ) {
            Text(text = symptom)
        }
    }
}

@Composable
fun rememberDatePicker(): DatePickerDialog {
    val context = LocalContext.current
    val datePickerDialog = DatePickerDialog(
        context,
        com.covid19.covidrapidtest.R.style.DatePickerDialogTheme,
        { _, year: Int, month: Int, dayOfMonth: Int ->
            println("$year, $month, $dayOfMonth")
        },
        2022, 5, 1
    )
    return remember { datePickerDialog }
}