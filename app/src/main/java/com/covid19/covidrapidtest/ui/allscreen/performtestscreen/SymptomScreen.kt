package com.covid19.covidrapidtest.ui.allscreen.performtestscreen

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import com.google.accompanist.flowlayout.FlowRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import com.covid19.covidrapidtest.R
import java.util.*

@Composable
fun SymptomScreen(navController: NavHostController) {

    var nameErrorCheck by remember { mutableStateOf(false) }
    var birthErrorCheck by remember { mutableStateOf(false) }
    var sexErrorCheck by remember { mutableStateOf(false) }
    val symptomErrorCheck by remember { mutableStateOf(false) }
    var firstVaccineErrorCheck by remember { mutableStateOf(false) }
    var secondVaccineErrorCheck by remember { mutableStateOf(false) }


    var nameValue by remember { mutableStateOf("name") }
    var birthValue by remember { mutableStateOf("birth") }
    var sexValue by remember { mutableStateOf("sex") }
    var symptomValue by remember { mutableStateOf("symptom") }
    var firstVaccineValue by remember { mutableStateOf("first") }
    var secondVaccineValue by remember { mutableStateOf("second") }

    var headacheCheckStatus by remember { mutableStateOf(false) }
    var achingMusclesCheckStatus by remember { mutableStateOf(false) }
    var shortnessOfBreathCheckStatus by remember { mutableStateOf(false) }
    var diarrheaCheckStatus by remember { mutableStateOf(false) }
    var fatigueCheckStatus by remember { mutableStateOf(false) }
    var feverOrChillsCheckStatus by remember { mutableStateOf(false) }
    var soreThroatCheckStatus by remember { mutableStateOf(false) }
    var lossOfTasteAndSmellCheckStatus by remember { mutableStateOf(false) }
    var coughCheckStatus by remember { mutableStateOf(false) }
    var runningNoseCheckStatus by remember { mutableStateOf(false) }
    var sneezingCheckStatus by remember { mutableStateOf(false) }
    var noSymptomCheckStatus by remember { mutableStateOf(false) }


    var text by remember{ mutableStateOf(TextFieldValue("")) }

    var shouldShowDialogForSymptom by remember{ mutableStateOf(false) }
    var shouldShowDialogForVaccine by remember{ mutableStateOf(false) }

    if (shouldShowDialogForSymptom){
        AlertDialog(
            onDismissRequest = {shouldShowDialogForSymptom = false},
            title = { androidx.compose.material.Text(text = "Notice") },
            text = { androidx.compose.material.Text(text = "You must select one symptom") },
            confirmButton = {
                Button(
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(
                        backgroundColor = AppColor
                    ),
                    onClick = {
                        shouldShowDialogForSymptom = false
                    }) {
                    androidx.compose.material3.Text(text = "ok", color = Color.White)
                }
            }

        )
    }
    if (shouldShowDialogForVaccine){
        AlertDialog(
            onDismissRequest = {shouldShowDialogForVaccine = false},
            title = { androidx.compose.material.Text(text = "Notice") },
            text = { androidx.compose.material.Text(text = "You must select two vaccine name") },
            confirmButton = {
                Button(
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(
                        backgroundColor = AppColor
                    ),
                    onClick = {
                        shouldShowDialogForVaccine = false
                    }) {
                    androidx.compose.material3.Text(text = "ok", color = Color.White)
                }
            }

        )
    }


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
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            tint = AppColor,
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Please enter your full name", color = if(nameErrorCheck) MaterialTheme.colors.error else Color.Black)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    colors = TextFieldDefaults
                        .outlinedTextFieldColors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.Gray,
                            cursorColor = AppColor,
                        ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                        nameValue = newText.text
                        nameErrorCheck = false
                    },
                    placeholder = {
                        Text(
                            text = "Enter you Full Name",
                            textAlign = TextAlign.Center
                        )
                    },
                    isError = nameErrorCheck
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Please Select your birth year and sex", color = if(birthErrorCheck) MaterialTheme.colors.error else Color.Black)
                Row {
                    Row(modifier = Modifier.weight(1f)) {
                        val suggestions = listOf("2022","2021","2020","2019")
                        CustomDropDownMenu("birth year",suggestions,
                            Modifier.padding(end = 4.dp),"birth"){
                            birthValue = it
                            //Log.d("SymptomScreen","birth select $it")
                        }
                    }
                    Row(modifier = Modifier.weight(1f)) {
                        val suggestions2 = listOf("Female", "Male")
                        CustomDropDownMenu("sex",suggestions2,
                            Modifier.padding(start = 4.dp),"sex"){
                            sexValue = it
                                //Log.d("SymptomScreen","sex select $it")

                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Do you have any symptom? Please check your symptoms", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(8.dp))
                //Symptoms()
                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth()
                ){
                    SymptomShow("headache"){
                        headacheCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "headache is selected" else "headache not selected")
                    }
                    SymptomShow("aching muscles"){
                        achingMusclesCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "aching muscles is selected" else "aching muscles not selected")
                    }
                    SymptomShow("shortness of breath"){
                        shortnessOfBreathCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "shortness of breath is selected" else "shortness of breath not selected")
                    }
                    SymptomShow("diarrhea"){
                        diarrheaCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "diarrhea is selected" else "diarrhea not selected")
                    }
                    SymptomShow("fatigue"){
                        fatigueCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "fatigue is selected" else "fatigue not selected")
                    }
                    SymptomShow("fever or chills"){
                        feverOrChillsCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "fever or chills is selected" else "fever or chills not selected")
                    }
                    SymptomShow("sore throat"){
                        soreThroatCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "sore throat" else "sore throat not selected")
                    }
                    SymptomShow("loss of taste and smell"){
                        lossOfTasteAndSmellCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "loss of taste and smell is selected" else "loss of taste and smell not selected")
                    }
                    SymptomShow("cough"){
                        coughCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "cough is selected" else "cough not selected")
                    }
                    SymptomShow("running nose"){
                        runningNoseCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "running nose is selected" else "running nose not selected")
                    }
                    SymptomShow("sneezing"){
                        sneezingCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "headache is selected" else "headache not selected")
                    }
                    SymptomShow("no symptom"){
                        noSymptomCheckStatus = it
                        Log.d("SymptomsButtonState", if (it) "no symptom is selected" else "no symptom not selected")
                    }
                }
                //Symptoms()

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Do you get vaccinated? Please select your vaccination details"
                        ,textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(8.dp))
                Column {

                    Row(verticalAlignment = Alignment.CenterVertically){
                        Row(modifier = Modifier.weight(1f)) {
                            val suggestions = listOf("Unvaccined","Pfizer-BioNTexh","Sinovac"
                                ,"Moderna","Janssen","AstraZeneca","Sputnik V","Others()")
                            CustomDropDownMenu("add vaccine",suggestions,
                                Modifier.padding(end = 4.dp),"first"){
                                    firstVaccineValue = it
                                   // Log.d("SymptomScreen","First vaccine select $it")

                            }
                        }
                        Row(modifier = Modifier.weight(1f)) {
                            ShowDatePicker(LocalContext.current)
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Row(modifier = Modifier.weight(1f)) {
                            val suggestions = listOf("Unvaccined","Pfizer-BioNTexh","Sinovac"
                                ,"Moderna","Janssen","AstraZeneca","Sputnik V","Others()")
                            CustomDropDownMenu("add vaccine",suggestions,
                                Modifier.padding(end = 4.dp),"second"){
                                secondVaccineValue = it
                                //Log.d("SymptomScreen","Second vaccine select $it")
                            }
                        }
                        Row(modifier = Modifier.weight(1f)) {
                            ShowDatePicker(LocalContext.current)
                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(
                    onClick = { }
                ) {
                    Icon(
                        tint = AppColor,
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = null
                    )
                }
                    Text(text = "Add another type of vaccine")
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = AppColor,
                onClick = {
                    nameErrorCheck = nameValue == "name"
                    birthErrorCheck = birthValue == "birth"
                    sexErrorCheck = sexValue == "sex"
                    firstVaccineErrorCheck = firstVaccineValue ==  "first"
                    secondVaccineErrorCheck = secondVaccineValue == "second"
                    nameErrorCheck = nameValue == "name"

                    Log.d("SelectecAllValue" ,"$nameValue $birthValue $sexValue $firstVaccineValue $secondVaccineValue")
                    if (
                        !headacheCheckStatus &&
                        !achingMusclesCheckStatus &&
                        !shortnessOfBreathCheckStatus &&
                        !diarrheaCheckStatus &&
                        !fatigueCheckStatus &&
                        !feverOrChillsCheckStatus &&
                        !soreThroatCheckStatus &&
                        !lossOfTasteAndSmellCheckStatus &&
                        !coughCheckStatus &&
                        !runningNoseCheckStatus &&
                        !sneezingCheckStatus &&
                        !noSymptomCheckStatus

                    ){
                        shouldShowDialogForSymptom = true
                    }else{
                        //shouldShowDialog.value = true

                        if(!firstVaccineErrorCheck && !secondVaccineErrorCheck){
                        }else{
                            shouldShowDialogForVaccine = true
                        }
                    }






//                    if (!nameErrorCheck &&
//                        !birthErrorCheck &&
//                        !sexErrorCheck &&
//                        !firstVaccineErrorCheck &&
//                        !secondVaccineErrorCheck){
//
//                        navController.navigate(Screen.WashHandScreen.route)
//                    }

                }
            ) {
                Icon(
                   tint = Color.White,
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Froward"
                )
            }
        },
        modifier = Modifier
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
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

}


@Composable
fun SymptomShow(symptom:String,giveButtonState:(buttonSelectState:Boolean)->Unit){
    var buttonValue by remember{ mutableStateOf(false) }
    if(buttonValue){
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = AppColor),
            onClick = {
            buttonValue = false
        }) {
            Text(text = symptom)
        }
    }else{
        OutlinedButton(
            border = BorderStroke(1.dp,color = AppColor),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = AppColor,),
            //modifier = Modifier.clip(),
            onClick = {
                buttonValue = true
            }
        ) {
            Text(text = symptom)
        }
    }
    giveButtonState(buttonValue)
}

@Composable
fun ShowDatePicker(context: Context){

    val calendar = Calendar.getInstance()
    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "${month+1}/$year"
        }, year, month, day
    )
    androidx.compose.material.OutlinedButton(
        onClick = {
        datePickerDialog.show()
    },
        modifier = Modifier.height(50.dp)
    ) {
       Row(
           horizontalArrangement = Arrangement.Center,
           verticalAlignment = Alignment.CenterVertically,

       ){
           Row(modifier = Modifier.weight(1f),
           verticalAlignment = Alignment.CenterVertically,
           ) {
               Image(
                   painter = painterResource(
                       id = R.drawable.calender_icon
                   ),
                   contentDescription = null,
               )
           }
           Row(modifier = Modifier.weight(1f),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Center
           ) {
               Text(text = if (date.value == "") "${month + 1}/$year" else date.value,
                   color = Color.Black,
               )
           }


       }

    }


}

@Composable
fun CustomDropDownMenu(label:String,suggestions: List<String>,modifier:Modifier,callerName:String, selectReturn:(String)->Unit ) {

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        OutlinedTextField(
            colors = TextFieldDefaults
                .outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = AppColor,
                    focusedLabelColor = AppColor
                ),
            value = selectedText,
            onValueChange = { selectedText = it
                                selectReturn(it)
                            },
            modifier = Modifier
                .height(60.dp)
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = {Text(label)},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    selectReturn(label)
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewSymptomScreen() {
    CovidRapidTestTheme {
        SymptomScreen(NavHostController(LocalContext.current))
    }
}