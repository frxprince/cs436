package com.drpaween.bytesconversion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
  var Multiplier:Double=0.0
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1234){
            if(resultCode== Activity.RESULT_OK){
                var a=data?.getStringExtra("data")?:"none"
                Multiplier=when(a){
                    "kb"->1/1000.0
                    "mb"->1/1000000.0
                    "gb"->1/1000000000.0
                    else->1.0
                }
     //          button2.text="$Multiplier"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_second)
        button.setOnClickListener(){
            var i= Intent(this,ThirdActivity::class.java)
            startActivityForResult(i,1234)
        }
        button2.setOnClickListener(){
            var i=Intent(this,FourthActivity::class.java)
            i.putExtra("input",editText.text.toString())
            i.putExtra("mux",Multiplier)
            startActivity(i)
        }
    }
}
