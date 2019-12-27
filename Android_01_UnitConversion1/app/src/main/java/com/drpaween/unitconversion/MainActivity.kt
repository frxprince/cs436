package com.drpaween.unitconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(){
       // Log.v("myApp","Hello world")
         //   textView.text="Hello World"
            try {
                var inputvalue: Double = editText.text.toString().toDouble()
                textView.text = "%.2f".format(inputvalue * 2.54) + " cm"
            }catch (e: NumberFormatException)
            {
              textView.text="Invalid input"
            }
        }
        button2.setOnClickListener(){
            try {
                textView.text = "${editText.text.toString().toDouble() / 2.54} inch"
            }catch (e:NumberFormatException){
                textView.text="Invalid input"
            }
        }

        button3.setOnClickListener(){ finish()}

    }
}
