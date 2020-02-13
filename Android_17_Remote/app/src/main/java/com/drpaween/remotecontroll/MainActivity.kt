package com.drpaween.remotecontroll

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mp3:MediaPlayer
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
  if (intent?.getStringExtra("mode")?:"no"=="meaw" )
  { mp3= MediaPlayer.create(this,R.raw.cat)
      mp3.start()
  }
   if (intent?.getStringExtra("mode")?:"no"=="alarm" )
   { mp3= MediaPlayer.create(this,R.raw.alarm)
     mp3.start()
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { finish() }
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!=
        PackageManager.PERMISSION_GRANTED)
ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS),
    1234)
    }
}
