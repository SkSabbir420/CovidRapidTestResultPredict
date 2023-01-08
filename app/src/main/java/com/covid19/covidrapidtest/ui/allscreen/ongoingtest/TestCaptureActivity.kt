package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.databinding.ActivityCaptureTestBinding


//import butterknife.ButterKnife
//import butterknife.OnClick

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}



class TestCaptureActivity : AppCompatActivity(), PhotoFragment.OnFragmentInteractionListener {
    var PERMISSION_ALL = 1
    var flagPermissions = false
    var PERMISSIONS = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )

    private lateinit var activityMainBinding:ActivityCaptureTestBinding

    //lateinit var uniqueKey:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //ButterKnife.bind(this)

        val bundle = Bundle()
        bundle.putString("nodeUniqueKey", intent.getStringExtra("nodeUniqueKey").toString())
        val photoFragment = PhotoFragment()
        photoFragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.res_photo_layout,photoFragment )
            .commit()

       // uniqueKey = intent.getStringExtra("nodeUniqueKey").toString()

        activityMainBinding = ActivityCaptureTestBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        checkPermissions()
        if (!flagPermissions) {
            checkPermissions()
        }else{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.res_photo_layout,photoFragment )
                //.addToBackStack(null)
                .commit()
        }

        activityMainBinding.makePhotoButton.setOnClickListener {

            //Log.d("MainActivityD","Start onClickScanButton")
            // check permissions
            if (!flagPermissions) {
                checkPermissions()
            }
                //start photo fragment
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.res_photo_layout, PhotoFragment())
                    //.addToBackStack(null)
                    .commit()

        }
    }

//    fun getCovidUniqueKey():String{
//        return uniqueKey
//    }



    private fun checkPermissions() {
        if (!hasPermissions(this, *PERMISSIONS)) {
            requestPermissions(
                PERMISSIONS,
                PERMISSION_ALL
            )
            flagPermissions = false
        }
        flagPermissions = true
    }

    override fun onFragmentInteraction(bitmap: Bitmap?, uniqueKey:String?) {
        //if (bitmap != null && uniqueKey != null) { //ToDo comment here
        if (bitmap != null) {
            val imageFragment = ImageFragment()
            imageFragment.imageSetupFragment(bitmap,uniqueKey)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.res_photo_layout, imageFragment)
                //.addToBackStack(null)
                .commit()
        }
    }

    companion object {
        fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
            if (context != null && permissions != null) {
                for (permission in permissions) {
                    if (ActivityCompat.checkSelfPermission(
                            context,
                            permission!!
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        return false
                    }
                }
            }
            return true
        }
    }
}