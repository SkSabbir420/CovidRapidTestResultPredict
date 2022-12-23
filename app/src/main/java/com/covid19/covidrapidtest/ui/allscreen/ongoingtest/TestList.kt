package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.covid19.covidrapidtest.ui.theme.AppColor
import com.covid19.covidrapidtest.ui.theme.Purple80

@Composable
fun TestList(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        val context = LocalContext.current
        Text(text = "Name")
        Spacer(modifier = Modifier.weight(1.0f))
        Button(
            onClick = {
                context.startActivity(Intent(context,TestCaptureActivity::class.java))

        }
        ) {
            Text(text = "take picture")
        }
        Icon(
            imageVector = Icons.Filled.Done,
            contentDescription =""
        )
    }
}

@Preview
@Composable
fun PreviewTestList(){
    TestList()
}