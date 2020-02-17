package com.drpaween.listsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener,SensorEventListener {
  lateinit var manager:SensorManager
    lateinit var sensor:Sensor
    lateinit var allsensor:MutableList<Sensor>

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
if (sensor!=null)manager.unregisterListener(this,sensor)
        sensor=allsensor[position]
        textView3.text="""
            Name:${sensor.name}
            Vender:${sensor.vendor}
            Version:${sensor.version}
            Max:${sensor.maximumRange}
            Resolution:${sensor.resolution}
        """.trimIndent()
    manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
    override fun onSensorChanged(event: SensorEvent?) {
        var msg:String=""
        for ((index,item)in event!!.values.withIndex())
        {
            msg+="Paramater:$index = $item\n"
        }
        textView2.text=msg
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        allsensor=manager.getSensorList(Sensor.TYPE_ALL)
        var sensor_name= mutableListOf<String>()
        for (item in allsensor){sensor_name.add(item.name)}
    var adapter=ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,sensor_name)
        spinner.adapter=adapter
        spinner.onItemSelectedListener=this
        sensor=allsensor[0]
    }
}
