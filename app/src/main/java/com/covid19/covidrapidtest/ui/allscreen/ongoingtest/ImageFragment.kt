package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.databinding.FragmentImageBinding
import com.covid19.covidrapidtest.ui.allscreen.common.fromobject.SymptomFrom
import com.covid19.covidrapidtest.ui.allscreen.ongoingtest.ongoingtestfeature.models.OngoingSymptomFrom
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.common.TensorOperator
import org.tensorflow.lite.support.common.TensorProcessor
import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.image.ops.ResizeWithCropOrPadOp
import org.tensorflow.lite.support.label.TensorLabel
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.util.*

//import butterknife.BindView
//import butterknife.ButterKnife

class ImageFragment : Fragment() {
    var curFile: Uri? = null

    val imageRef = Firebase.storage.reference


    //private var bitmap: Bitmap? = null

    // private var myUrl = ""
    private var classify:String? = null
    // private var imageUri: Uri? = null
    //    private var storagePostPicRef: StorageReference? = null
    private var bitmap: Bitmap? = null
    private var uniqueKey: String? = null
    protected var tflite: Interpreter? = null
    private var imageSizeX = 0
    private var imageSizeY = 0
    private var inputImageBuffer: TensorImage? = null
    private var outputProbabilityBuffer: TensorBuffer? = null
    private var probabilityProcessor: TensorProcessor? = null
    private var labels: List<String>? = null
    // private var ourMember = false
    // private var verifiedUser = false
    private lateinit var qrCodeShow:ImageView

    //@BindView(R.id.res_photo)
    //var resPhoto: ImageView? = null

    //@BindView(R.id.res_photo_size)
    //var resPhotoSize: TextView? = null
    private lateinit var fragmentBindingImage: FragmentImageBinding

    fun imageSetupFragment(bitmap: Bitmap?,uniqueKey:String?) {
        if (bitmap != null && uniqueKey != null) {
            this.bitmap = bitmap
            this.uniqueKey = uniqueKey
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setRetainInstance(true)
        fragmentBindingImage = FragmentImageBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_image, container, false)

        val deviceID = Settings.Secure.getString(context!!.contentResolver, Settings.Secure.ANDROID_ID) //me be case for crash


        try {
            ///Main code 1
            tflite = Interpreter(loadmodelfile(context as Activity))
        } catch (e: Exception) {
            //e.printStackTrace();
            Toast.makeText(context, "Dont load model!!", Toast.LENGTH_SHORT).show()
        }
        val imgFile = File("/storage/emulated/0/Pictures/region_.jpg")
        curFile = Uri.fromFile(imgFile)

        if (imgFile.exists()) {
            bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath())
        }
        val imageTensorIndex = 0
        val imageShape =
            tflite!!.getInputTensor(imageTensorIndex).shape() // {1, height, width, 3}
        //Toast.makeText(MainActivity.this,Integer.toString(imageShape[1]),Toast.LENGTH_SHORT).show();
        imageSizeY = imageShape[1] //224
        //Toast.makeText(MainActivity.this,Integer.toString(imageSizeY),Toast.LENGTH_SHORT).show();
        imageSizeX = imageShape[2] //224
        //Toast.makeText(MainActivity.this,Integer.toString(imageSizeX),Toast.LENGTH_SHORT).show();
        val imageDataType = tflite!!.getInputTensor(imageTensorIndex).dataType()
        val probabilityTensorIndex = 0
        val probabilityShape = tflite!!.getOutputTensor(probabilityTensorIndex).shape() // {1, NUM_CLASSES}
        //Toast.makeText(this,Integer.toString(probabilityShape[0]),Toast.LENGTH_SHORT).show();
        val probabilityDataType = tflite!!.getOutputTensor(probabilityTensorIndex).dataType()
        inputImageBuffer = TensorImage(imageDataType)
        val info = """
                image with:${bitmap!!.width}
                image height:${bitmap!!.height}
                """.trimIndent()
        Log.d("Sabbir",info)
        inputImageBuffer = loadImage(bitmap) ///vvimp

        outputProbabilityBuffer = TensorBuffer.createFixedSize(probabilityShape, probabilityDataType)
        probabilityProcessor = TensorProcessor.Builder().add(postprocessNormalizeOp).build()
        tflite!!.run(inputImageBuffer!!.buffer, outputProbabilityBuffer!!.buffer.rewind())
        Log.d("ImageFragment",showresult())



        //ButterKnife.bind(this, view)
        //check if bitmap exist, set to ImageView
        val imageView = view.findViewById<ImageView>(R.id.res_photo)
        //val imagePhotoSize = view.findViewById<TextView>(R.id.res_photo_size)

        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
            val info = """
                image with:${bitmap!!.width}
                image height:${bitmap!!.height}
                """.trimIndent()
            //imagePhotoSize.text = info

        }

        val goToResultActivity = view.findViewById<Button>(R.id.btn_go_result_activity)
        goToResultActivity.setOnClickListener {
            try {
                GlobalScope.launch {

                    val retriveData = FirebaseFirestore.getInstance().collection("covidTestDatabase")
                        .document(deviceID).collection("fromFillUp").document("$uniqueKey").get().await()
                    val finaldata =  retriveData.toObject<OngoingSymptomFrom>()
                    Log.d("MainActivityfinalData","$finaldata")


                    curFile?.let {
                        val image = imageRef.child("covidTestStorage").child(deviceID).child("$uniqueKey.jpg").putFile(it).await()
                        image.storage.downloadUrl.addOnSuccessListener { uri ->
                            if (finaldata != null){
                                finaldata.testResult = classify.toString()
                                finaldata.testResultImageUrl = uri.toString()
                                FirebaseFirestore.getInstance().collection("covidTestDatabase")
                                    .document(deviceID).collection("finalTestResult").document("$uniqueKey")
                                    .set(finaldata)
                                Firebase.firestore.collection("covidTestDatabase").document(deviceID).collection("fromFillUp")
                                    .document("$uniqueKey").delete()

                            }
                            Log.d("MainActivity","$uniqueKey")
                            Log.d("MainActivity",uri.toString())
                        }

                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Successfully uploaded image",
                                Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }catch (e:Exception){ }


            if (bitmap!= null) {
                val resultActivity = ResultActivity()

                resultActivity.setBitMap(bitmap)
                val intent = Intent(context,resultActivity::class.java)
                intent.putExtra("key",uniqueKey)
                startActivity(intent)
            }
        }

        return view
    }

    fun loadmodelfile(activity: Activity): MappedByteBuffer {
//        val fileDescriptor = activity.assets.openFd("model.tflite")
//        val fileDescriptor = activity.assets.openFd("newmodel.tflite")
        val fileDescriptor = activity.assets.openFd("modelC.tflite")
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startoffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        //Toast.makeText(MainActivity.this,Long.toString(declaredLength),Toast.LENGTH_SHORT).show();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startoffset, declaredLength)
    }

    private fun showresult():String {
        try {
            labels = FileUtil.loadLabels(context!!, "labelsC.txt")
            //labels = FileUtil.loadLabels(this, "label.txt")
//            labels = FileUtil.loadLabels(this, "newdict.txt")
        }catch (e: Exception) {
            Toast.makeText(context, "testtext not work", Toast.LENGTH_SHORT).show()
        }

        try {
            val labeledProbability = TensorLabel(labels!!,
                probabilityProcessor!!.process(outputProbabilityBuffer) ).mapWithFloatValue
            val maxValueInMap = Collections.max(labeledProbability.values)
            for ((key, value) in labeledProbability) {
                if (value == maxValueInMap) {
//                    if(key != "Islamic"){
//                        Toast.makeText(this, key+"! Please Add Islamic Photo.", Toast.LENGTH_SHORT).show()
//                    }
                    //classitext!!.text = key
                    classify = key
                    //createQrCode(key)
                    Toast.makeText(context, key + "", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            //Toast.makeText(this, "show 2nd part not work!!", Toast.LENGTH_SHORT).show()
            Toast.makeText(context, "$e", Toast.LENGTH_SHORT).show()
            Log.d("MainActiviy",e.toString())
        }
        return classify!!
    }
    private fun loadImage(bitmap: Bitmap?): TensorImage {
        // Loads bitmap into a TensorImage.
        inputImageBuffer!!.load(bitmap!!)

        // Creates processor for the TensorImage.
        val cropSize = Math.min(bitmap.width, bitmap.height)
        // TODO(b/143564309): Fuse ops inside ImageProcessor.
        val imageProcessor = ImageProcessor.Builder()
            .add(ResizeWithCropOrPadOp(cropSize, cropSize))
            .add(ResizeOp(imageSizeX, imageSizeY, ResizeOp.ResizeMethod.NEAREST_NEIGHBOR))
            .add(preprocessNormalizeOp)
            .build()
        return imageProcessor.process(inputImageBuffer)
    }

    private val preprocessNormalizeOp: TensorOperator
        private get() = NormalizeOp(IMAGE_MEAN, IMAGE_STD)
    private val postprocessNormalizeOp: TensorOperator
        private get() = NormalizeOp(PROBABILITY_MEAN, PROBABILITY_STD)

    companion object {
        const val IMAGE_MEAN = 0.0f
        const val IMAGE_STD = 1.0f
        const val PROBABILITY_MEAN = 0.0f
        const val PROBABILITY_STD = 255.0f
    }




}