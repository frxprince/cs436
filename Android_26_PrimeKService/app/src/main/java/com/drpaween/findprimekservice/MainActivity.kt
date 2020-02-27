package com.drpaween.findprimekservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
var receiver=object:MyReceiver(){
    override fun ShowResult(x: String) {
        textView.text=x
    }
}

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        textView.text=intent!!.getLongExtra("result",0).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(receiver, IntentFilter("com.drpaween.findprimekservice"))
button.setOnClickListener {
    var i = Intent(this,PrimeIntentService::class.java)
    i.putExtra("k",editText.text.toString().toLong())
    i.setAction("start")
    startService(i)
}
    }

abstract class MyReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        ShowResult(intent!!.getLongExtra("result",0).toString())
       }
    abstract fun ShowResult(x:String)

}
}
