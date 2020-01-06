package com.drpaween.bytesconversion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fourth.*

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        var i=this.intent
        var inputx=i.getStringExtra("input")
        var multiplier=i.getDoubleExtra("mux",0.0)
        textView2.text=" input:$inputx \n"+ "%.10f".format( inputx.toDouble()*multiplier)

        //textView2.text=" input:$inputx \n = ${inputx.toDouble()*multiplier}"

    }
}
