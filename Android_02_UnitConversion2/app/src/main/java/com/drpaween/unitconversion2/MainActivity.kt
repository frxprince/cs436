package com.drpaween.unitconversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     button.setOnClickListener(){
      var inputvalue=editText.text.toString().toDouble()
         var ans=if (radioButton.isChecked) inputvalue*2.54 else inputvalue/2.54
         var suffix=if(radioButton.isChecked) resources.getString(R.string.cm)
         else resources.getString(R.string.inch)
     textView.text="%.2f".format(ans)+ "$suffix"
     }
    }
}
