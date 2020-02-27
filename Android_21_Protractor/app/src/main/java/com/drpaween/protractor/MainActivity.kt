package com.drpaween.protractor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.PI
import kotlin.math.atan2

class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var manager:SensorManager
    lateinit var sensor:Sensor
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {    }

    override fun onSensorChanged(event: SensorEvent?){
        textView.text="${event!!.values[0]},${event!!.values[1]},${event!!.values[2]}"
    var degree= (atan2(event.values[1],event.values[0])/PI)*180.0
        textView2.text=degree.toString()
        seekBar.max=360
        seekBar.setProgress((-degree+180.0).toInt())
    }
    override fun onPause() {
        super.onPause();manager.unregisterListener(this,sensor)
    }
    override fun onResume() {
        super.onResume();
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
   seekBar.progressDrawable=ContextCompat.getDrawable(this,R.mipmap.bg)
        seekBar.background=ContextCompat.getDrawable(this,R.mipmap.border)
    }
}
