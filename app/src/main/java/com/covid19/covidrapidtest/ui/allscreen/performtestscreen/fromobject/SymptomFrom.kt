package com.covid19.covidrapidtest.ui.allscreen.performtestscreen.fromobject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class  SymptomFrom(
    var lotNumber:String ="1234",
    var nameValue:String ="DefaultName",
    var birthValue:String ="DefaultBirth",
    var sexValue:String ="DefaultSex",
    var firstVaccineValue:String ="DefaultFirstVaccine",
    var secondVaccineValue:String ="DefaultSecondVaccine",
    var thirdVaccineValue:String ="DefaultThirdVaccine",
    var headacheCheckStatus:Boolean =false,
    var achingMusclesCheckStatus:Boolean =false,
    var shortnessOfBreathCheckStatus:Boolean =false,
    var diarrheaCheckStatus:Boolean =false,
    var fatigueCheckStatus:Boolean =false,
    var feverOrChillsCheckStatus:Boolean =false,
    var soreThroatCheckStatus:Boolean =false,
    var lossOfTasteAndSmellCheckStatus:Boolean =false,
    var coughCheckStatus:Boolean =false,
    var runningNoseCheckStatus:Boolean =false,
    var sneezingCheckStatus:Boolean =false,
    var noSymptomCheckStatus:Boolean =false
):Parcelable