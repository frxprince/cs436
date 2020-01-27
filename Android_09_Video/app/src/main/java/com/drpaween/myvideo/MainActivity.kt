package com.drpaween.myvideo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            videoView.setVideoURI(Uri.parse("android.resource://"+
            packageName+"/"+R.raw.video2))
        }
   videoView.setMediaController(MediaController(this))
  imageButton.setOnClickListener{ videoView.start()}
  imageButton2.setOnClickListener { videoView.pause() }
  imageButton3.setOnClickListener { videoView.stopPlayback() }
    }
}
