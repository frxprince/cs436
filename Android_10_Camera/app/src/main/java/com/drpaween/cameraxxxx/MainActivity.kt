package com.drpaween.cameraxxxx

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
     var bitmap:Bitmap?=null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK){
            if(bitmap!=null)bitmap?.recycle()
          bitmap=data!!.extras!!.getParcelable("data")
          var canvas= Canvas(bitmap!!)
            var paint= Paint()
            paint.setColor(Color.RED)
            paint.textSize=8F
            paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_OVER))
            canvas.drawBitmap(bitmap!!,0f,0f,paint)
            canvas.drawText("CSMJU",1F,30F,paint)

            imageView.setImageBitmap(bitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 button.setOnClickListener {
     var i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
     startActivityForResult(i,1234)

 }
 if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
         PackageManager.PERMISSION_GRANTED)
  ActivityCompat.requestPermissions(this,
      arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),123)

button2.setOnClickListener {
    if(bitmap!=null){
        var file= File(Environment.getExternalStorageDirectory().path+"/DCIM/hello.png")
        file.createNewFile()
        var bos=ByteArrayOutputStream()
        bitmap!!.compress(Bitmap.CompressFormat.PNG,99,bos)
        var fos=FileOutputStream(file)
        fos.write(bos.toByteArray())
        fos.flush()
        fos.close()
        Toast.makeText(this, "The image is saved!", Toast.LENGTH_LONG).show()
    }
}




    }
}
