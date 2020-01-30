package com.drpaween.cameraxxxx

import android.app.Activity
import android.content.Intent
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*

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
    }
}
