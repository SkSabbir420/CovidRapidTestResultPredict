package com.covid19.covidrapidtest.ui.allscreen.pdf_screen

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.camera.core.impl.utils.ContextUtil.getApplicationContext
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.navigation.Screen
import com.covid19.covidrapidtest.ui.theme.CovidRapidTestTheme
import com.itextpdf.barcodes.BarcodeQRCode
import com.itextpdf.kernel.colors.ColorConstants
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.properties.HorizontalAlignment
import com.itextpdf.layout.properties.TextAlignment
import java.io.File


@Composable
fun PdfShowScreen(navController:NavController,backRoute:String,key:String?){

    var ongoingSymptomFrom:OngoingSymptomFrom? = null


    Log.d("KeyPass",key.toString())
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxHeight(0.1f),
                title = {
                        Image(
                            painter = painterResource(
                                id = R.drawable.image_logo
                            ),
                            contentDescription = "Image Logo",
                        )
                },
                navigationIcon = {
                    IconButton(onClick = {

                        if(backRoute == Screen.DisposeScreen.route){
                            navController.navigate(Screen.OnGoingTest.route)
                        }else{
                        navController.popBackStack()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription =""
                        )
                    }
                },

                actions = {
                    IconButton(
                        modifier = Modifier
                            .height(35.dp)
                            .width(35.dp),
                        onClick = {
                        //navController.navigate(Screen.ActionButtonScreen.route)

                            if (ongoingSymptomFrom != null) {

                            val path = Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_PICTURES
                            )
                            val imageFileName = "myPdf.pdf"
                            val file = File(path, imageFileName)

                            val writer = PdfWriter(file)
                            val pdfDocument = PdfDocument(writer)
                            val document = Document(pdfDocument)

                            val table = Table(2)
                            table.setHorizontalAlignment(HorizontalAlignment.CENTER)

                            table.addCell( Cell().add(Paragraph("Test Result")))
                            table.addCell( Cell().add(Paragraph(ongoingSymptomFrom!!.testResult)))

                            table.addCell( Cell().add(Paragraph("Test Date")))
                            table.addCell( Cell().add(Paragraph(ongoingSymptomFrom!!.createTime)))

                            table.addCell( Cell().add(Paragraph("Full Name")))
                            table.addCell( Cell().add(Paragraph(ongoingSymptomFrom!!.nameValue)))

                            table.addCell( Cell().add(Paragraph("Age")))
                            table.addCell( Cell().add(Paragraph(ongoingSymptomFrom!!.birthValue)))

                            table.addCell( Cell().add(Paragraph("Gender")))
                            table.addCell( Cell().add(Paragraph(ongoingSymptomFrom!!.sexValue)))

                            table.addCell( Cell().add(Paragraph("Product")))
                            table.addCell( Cell().add(Paragraph("RapidFor TM SARS-CoV-2 Rapid Antigen Test")))

                            table.addCell( Cell().add(Paragraph("LOT")))
                            table.addCell( Cell().add(Paragraph(ongoingSymptomFrom!!.lotNumber)))

                            table.addCell( Cell().add(Paragraph("Manufacture")))
                            table.addCell( Cell().add(Paragraph("Vitrosens Biyoteknoloji Ltd.Sti")))

                            table.addCell( Cell().add(Paragraph("Test Number")))
                            table.addCell( Cell().add(Paragraph(ongoingSymptomFrom!!.nodeUniqueKey)))

                            val para = Paragraph("QR Code of Unique Test").setTextAlignment(TextAlignment.CENTER)

                            val qrCode = BarcodeQRCode(ongoingSymptomFrom!!.nodeUniqueKey)
                            val qrcodeObject = qrCode.createFormXObject(ColorConstants.BLACK,pdfDocument)
                            val qrCodeImage = Image(qrcodeObject).setWidth(80f).setHorizontalAlignment(HorizontalAlignment.CENTER)

                            document.add(table)
                            document.add(para)
                            document.add(qrCodeImage)
                            document.close()
                            Log.d("PdfStatus", "Your pdf created")

//                                val imgFile = File("/storage/emulated/0/Pictures/region_.jpg")
//                                if (imgFile.exists()) {
//                                    val bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath())
//                                }

                                //Toast.makeText(LocalContext,"",Toast.LENGTH_SHORT).show()
//                                //File("/storage/emulated/0/Pictures/region_.jpg")
//                                val intent = Intent(Intent.ACTION_VIEW,MediaStore.Downloads.EXTERNAL_CONTENT_URI)
//                                intent.setType("application/pdf")

                            }
                    }) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.pdf_icon
                            ),
                            contentDescription = null,
                        )
                    }

                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },


        content = {
            //PdfContentScreen()
            if (key != null) {
                FinalResultShowInPdf(navController,key){
                    ongoingSymptomFrom = it
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPdfPreview() {
    CovidRapidTestTheme {
       // PdfShowScreen(navController = NavHostController(LocalContext.current),)
    }
}