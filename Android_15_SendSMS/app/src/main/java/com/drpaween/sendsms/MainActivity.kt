package com.drpaween.sendsms

import android.Manifest
import android.app.Activity
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!=
        PackageManager.PERMISSION_GRANTED)
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),
        12)
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE)!=
            PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_PHONE_STATE),
        12)
var sentPI=PendingIntent.getBroadcast(this,0, Intent("SMS_SENT"),0)
var deliveredPI=PendingIntent.getBroadcast(this,0,
    Intent("SMS_DELIVERED"),0)

button.setOnClickListener {
 var sms=SmsManager.getDefault()
 sms.sendTextMessage(editText.text.toString(),"191",editText3.text.toString(),
     sentPI,deliveredPI)
}
var mySMSsent=object:SMSsent(){
    override fun show(msg: String) {
      textView.text=textView.text.toString() + msg +"\n"
    }
}
var mySMSdelivered= object:SMSdelivered(){
    override fun show(msg: String) {
     textView.text=textView.text.toString() + msg +"\n"
    }
}
     registerReceiver(mySMSsent, IntentFilter("SMS_SENT"))
        registerReceiver(mySMSdelivered,IntentFilter("SMS_DELIVERED"))
     }

abstract class SMSsent:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
      var msg=when(resultCode){
       Activity.RESULT_OK->"SMS is sent"
       SmsManager.RESULT_ERROR_GENERIC_FAILURE ->"Generic error"
       SmsManager.RESULT_ERROR_RADIO_OFF->"Flight mode Error"
       SmsManager.RESULT_ERROR_NO_SERVICE->"No service!"
          else->"I don't know"
      }
        show(msg)
    }
    abstract fun show(msg:String)
}
abstract class SMSdelivered:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
      var msg=when(resultCode){
          Activity.RESULT_OK->"The SMS is delivered!!"
          else->"Fail!!!"
      }
        show(msg)
    }
abstract fun show(msg:String)
}




}
