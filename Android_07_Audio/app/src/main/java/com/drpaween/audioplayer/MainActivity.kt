package com.drpaween.audioplayer

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var Mp:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(){
            Mp= MediaPlayer()
            Mp= MediaPlayer.create(this,R.raw.greeting)
        }
        button5.setOnClickListener(){
            Mp.start()
        }
        button2.setOnClickListener(){
            Mp= MediaPlayer()
      var mp3file=assets.openFd("mp3/tada.mp3")
    Mp.setDataSource(mp3file.fileDescriptor,mp3file.startOffset,mp3file.length)
    Mp.prepare()
        }
        button6.setOnClickListener(){Mp.pause()}
        button7.setOnClickListener(){Mp.stop()}
     if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=
         PackageManager.PERMISSION_GRANTED){
         ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET)
             ,1234)
     }
        button4.setOnClickListener(){
         Mp= MediaPlayer()
         Mp.setDataSource(this, Uri.parse("http://www.drpaween.com/ohm/mp3test.mp3"))
            Mp.prepare()
        }
if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=
        PackageManager.PERMISSION_GRANTED)
    ActivityCompat.requestPermissions(this,
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),123)

button3.setOnClickListener {
    Mp= MediaPlayer()
    //Mp.setDataSource("/mnt/sdcard/song.mp3")
    Mp.setDataSource(Environment.getExternalStorageDirectory().path+"/song.mp3")
    Mp.prepare()
}






    }

}
