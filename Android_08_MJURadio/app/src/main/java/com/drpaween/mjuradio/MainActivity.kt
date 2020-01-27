package com.drpaween.mjuradio

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var Mp:MediaPlayer
    override fun onPause() {
        super.onPause()
        Mp.stop()
    }

    override fun onResume() {
        super.onResume()
        Mp=MediaPlayer()
        Mp.setDataSource(this,
            Uri.parse("http://112.121.150.133:8282/;stream"))
        Mp.prepare()
        Mp.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { finish() }
if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=
        PackageManager.PERMISSION_GRANTED)
    ActivityCompat.requestPermissions(this,
        arrayOf(Manifest.permission.INTERNET),124)

    }
}
