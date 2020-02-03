package com.drpaween.filepicker

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK) {
            textView.text = data!!.data.toString()
            //  To be continue....
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
button.setOnClickListener {
    var i= Intent()
    i.type="*/*"
    i.setAction(Intent.ACTION_GET_CONTENT)
    startActivityForResult(Intent.createChooser(i,"Pick a file"),123)
}
    }
}
