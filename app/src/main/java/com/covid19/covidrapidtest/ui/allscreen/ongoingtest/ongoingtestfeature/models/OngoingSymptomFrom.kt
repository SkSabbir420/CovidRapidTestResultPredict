package com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models

//data class Food(var Image: String? = null, var Name: String? = null)

data class  OngoingSymptomFrom(

    var deviceId:String = "DefaultDeviceId",
    var nodeUniqueKey:String = "DefaultNodeKey",
    var deviceIdLocation:String = "DefaultLocation",
    var testResultImageUrl:String = "DefaultUrl",
    var testResult:String = "DefaultTest",
    var lotNumber:String ="DefaultLotNumber",
    var createTime:String ="DefaultTime",
    var nameValue:String ="DefaultName",
    var birthValue:String ="DefaultBirth",
    var sexValue:String ="DefaultSex",
    var firstVaccineValue:String ="DefaultFirstVaccine",
    var secondVaccineValue:String ="DefaultSecondVaccine",
    var thirdVaccineValue:String ="DefaultThirdVaccine",
    var firstVaccineDate:String ="DefaultFirstVaccineDate",
    var secondVaccineDate:String ="DefaultSecondVaccineDate",
    var thirdVaccineDate:String ="DefaultThirdVaccineDate",
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

)