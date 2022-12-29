package com.covid19.covidrapidtest.ui.allscreen.ongoingtest

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.covid19.covidrapidtest.R
import com.covid19.covidrapidtest.ui.navigation.PdfNavGraph
import com.covid19.covidrapidtest.ui.navigation.SetupNavGraph
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
//import com.theartofdev.edmodo.cropper.CropImage
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
import java.io.FileOutputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    private var myUrl = ""
    private var classify:String? = null
    private var imageUri: Uri? = null
    //    private var storagePostPicRef: StorageReference? = null
    private var bitmap: Bitmap? = null
    protected var tflite: Interpreter? = null
    private var imageSizeX = 0
    private var imageSizeY = 0
    private var inputImageBuffer: TensorImage? = null
    private var outputProbabilityBuffer: TensorBuffer? = null
    private var probabilityProcessor: TensorProcessor? = null
    private var labels: List<String>? = null
    private var ourMember = false
    private var verifiedUser = false
    private lateinit var qrCodeShow:ImageView


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_result)
        setContent {
            //DisposeScreen()
            val context = LocalContext.current
            val navController = rememberNavController()
            PdfNavGraph(navController = navController,context)
        }


        try {
            ///Main code 1
            tflite = Interpreter(loadmodelfile(this))
        } catch (e: Exception) {
            //e.printStackTrace();
            Toast.makeText(this, "Dont load model!!", Toast.LENGTH_SHORT).show()
        }

        //val imageAdd = findViewById<Button>(R.id.image_post)

        //val showResult= findViewById<TextView>(R.id.tv_resultShow)
        //val cratePdf= findViewById<Button>(R.id.btn_pdf_crate)
        //qrCodeShow= findViewById<ImageView>(R.id.ivQRCode)
        //cratePdf.setOnClickListener {
            //if (classify != null){
                //savePDF(classify!!)
            //}
       // }


//        save_new_post_btn.setOnClickListener {
//            uploadImage()
//        }

//        imageAdd.setOnClickListener {
//            CropImage.activity().setAspectRatio(9, 16).
//            start(this@MainActivity)
//        }



//        video_post.setOnClickListener {
//            loadImage()
//        }
//        image_post.setOnClickListener {
//            loadImage()
//        }

        //Main code 2.

       // showResult.setOnClickListener {

//            if (imageUri ==null){
//                Toast.makeText(this, "Please add your photo", Toast.LENGTH_LONG).show()
//                return@setOnClickListener
//            }

        val imgFile = File("/storage/emulated/0/Pictures/region_.jpg")
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
            // after execution
            // after execution
//            val result = outputProbabilityBuffer!!.floatArray[0]
//
//            if (result < 0.5) {
//                classify = "The image classified is Covid Negetive. Confident:$result "
//                Toast.makeText(this, "The image classified is Covid Negetive.\n Confident:$result ", Toast.LENGTH_SHORT).show()
//            } else {
//                classify="The image classified is Covid Positive Confident:$result "
//                Toast.makeText(this, "The image classified is Covid Negetive.\n Confident:$result ", Toast.LENGTH_SHORT).show()
//            }

        //showResult.text = showresult() //comment by sabbir

       // }

    } //One create is end.

    fun setBitMap(bitmap: Bitmap?) {
        Log.d("MainActivityD","call Set Bit map")
        if (bitmap != null) {
            Log.d("MainActivityD","Bitmap is inisialize")
            this.bitmap = bitmap
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE  &&  resultCode == Activity.RESULT_OK  &&  data != null)
//        {
//            val result = CropImage.getActivityResult(data)
//            imageUri = result.uri
//
//            //image_post.setImageURI(imageUri)
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
////                image_post.setImageBitmap(bitmap)
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }
//    }

    //Main code 1.
    //@Throws(IOException::class)
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
            labels = FileUtil.loadLabels(this, "labelsC.txt")
            //labels = FileUtil.loadLabels(this, "label.txt")
//            labels = FileUtil.loadLabels(this, "newdict.txt")
        }catch (e: Exception) {
            Toast.makeText(this, "testtext not work", Toast.LENGTH_SHORT).show()
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
                    createQrCode(key)
                    Toast.makeText(this, key + "", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            //Toast.makeText(this, "show 2nd part not work!!", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
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

    private fun createQrCode(data:String){
        val writer = QRCodeWriter()
        try {
            val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE,512,512)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bmp = Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565)
            for(x in 0 until width){
                for (y in 0 until height){
                    bmp.setPixel(x,y,if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                }
            }
            qrCodeShow.setImageBitmap(bmp)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun savePDF(data:String) {
        val mDoc = Document()
        val mFileName = SimpleDateFormat("yyyMMdd_HHmmss", Locale.getDefault())
            .format(System.currentTimeMillis())

        val mFilePath = Environment.getExternalStorageDirectory().toString() + "/"  + mFileName + ".pdf"

        try {
            PdfWriter.getInstance(mDoc, FileOutputStream(mFilePath))
            mDoc.open()
            mDoc.addAuthor("Sabbir")
            mDoc.add(Paragraph(data))
            mDoc.close()
            Toast.makeText(this,"$mFilePath.pdf\n is create to \n$mFilePath",Toast.LENGTH_SHORT).show()
        }catch (e:Exception){
            Toast.makeText(this,"" + e.toString(),Toast.LENGTH_SHORT).show()
        }
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


}//end.


