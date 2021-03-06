package com.drpaween.luxmeter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,SensorEventListener{
    override fun onPause() {  super.onPause()
        manager.unregisterListener(this,sensor)
    }
    override fun onResume() {        super.onResume()
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    override fun onSensorChanged(event: SensorEvent?) {textView.text=event!!.values[0].toString()
     }
lateinit var manager:SensorManager
    lateinit var sensor:Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
sensor=manager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }
}
