package com.drpaween.implicitintent

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.Contract

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(){
         var i= Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mju.ac.th"))
         if(i.resolveActivity(packageManager)!=null) {
             startActivity(i)
         }else{
             button.text="Not support"
             button.isEnabled=false
         }
        }
        button2.setOnClickListener(){
            var i=Intent(Intent.ACTION_VIEW,Uri.parse("geo:35.1593326,129.0340827"))
            startActivity(i)
        }
        if (ContextCompat.checkSelfPermission(this,
                "com.android.alarm.permission.SET_ALARM")
        !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf("com.android.alarm.permission.SET_ALARM"),
                1234)
        }
        button3.setOnClickListener(){
        var i=Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE,"Time's up!!!")
            putExtra(AlarmClock.EXTRA_LENGTH,10)
            putExtra(AlarmClock.EXTRA_SKIP_UI,true)
        }
            startActivity(i)
        }
        button4.setOnClickListener(){
            var i=Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivity(i)
        }



    }
}
