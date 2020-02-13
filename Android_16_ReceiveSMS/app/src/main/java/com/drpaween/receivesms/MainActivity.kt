package com.drpaween.receivesms

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!=
        PackageManager.PERMISSION_GRANTED)
 ActivityCompat.requestPermissions(this,
     arrayOf(Manifest.permission.RECEIVE_SMS),12)
 var smsreceiver=object:myReceiver(){
     override fun show(phone_number: String, body: String) {
         textView.text="SMS from:$phone_number\nThe message is :\n$body"
     }
 }
   registerReceiver(smsreceiver, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
    }

abstract class myReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
       var message=Telephony.Sms.Intents.getMessagesFromIntent(intent)[0]
       show( message.displayOriginatingAddress,message.displayMessageBody)
    }
abstract fun show(phone_number:String,body:String)
}
}
