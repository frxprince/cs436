package com.drpaween.text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener {
            var file=assets.open("textfile/pangram.txt")
            var lines=file.bufferedReader(Charsets.UTF_8).readLines()
            var msg=""
            for( line in lines)
            {
               msg=msg+line+"\n"
            }
            editText2.setText(msg)
        }
    }
}
