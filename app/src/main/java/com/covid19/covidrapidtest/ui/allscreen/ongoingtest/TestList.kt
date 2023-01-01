package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import android.content.Intent
import android.util.Log
import androidx.camera.core.impl.utils.ContextUtil.getBaseContext
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.covid19.covidrapidtest.ui.theme.AppColor


@Composable
fun TestList(SymptomFromData: OngoingSymptomFrom){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(AppColor)
            .clickable {
                Log.d("GetKey", SymptomFromData.nodeUniqueKey)
            },
        verticalAlignment = Alignment.CenterVertically

    ) {
        val context = LocalContext.current
        Text(text = SymptomFromData.nameValue , modifier = Modifier.padding(16.dp), color = Color.White)
        Spacer(modifier = Modifier.weight(1.0f))
        Button(colors = ButtonDefaults.buttonColors(
            containerColor = Green
        ),
            onClick = {

                val intent = Intent(context, TestCaptureActivity::class.java)
                intent.putExtra("nodeUniqueKey", SymptomFromData.nodeUniqueKey)
                context.startActivity(intent)
                //context.startActivity(Intent(context,TestCaptureActivity::class.java))

        }
        ) {
            Text(text = "take picture", color = Color.White)
        }
        Icon(
            tint = Color.White,
            modifier = Modifier.padding(16.dp),
            imageVector = Icons.Outlined.CheckCircle,
            contentDescription =""
        )
    }
}

@Preview
@Composable
fun PreviewTestList(){
    //TestList()
}