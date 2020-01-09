package com.drpaween.mylauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(){
            var i= packageManager.getLaunchIntentForPackage(
                "com.google.android.youtube")
            Log.v("myintent",i.toString())
          startActivity(i)
        }
        button2.setOnClickListener(){
            var i= packageManager.getLaunchIntentForPackage(
                "com.android.deskclock")
            startActivity(i)
        }
        button3.setOnClickListener(){
            var i= packageManager.getLaunchIntentForPackage(
                "com.android.settings")
            startActivity(i)
        }
    }
}
