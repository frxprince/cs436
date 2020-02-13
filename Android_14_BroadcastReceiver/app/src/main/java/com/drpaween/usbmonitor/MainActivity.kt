package com.drpaween.usbmonitor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myreceiver: Myreceiver
    override fun onPause() {
        super.onPause()
        unregisterReceiver(myreceiver)
    }
    override fun onResume() {
        super.onResume()
        registerReceiver(myreceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.max=100
     myreceiver=object: Myreceiver(){
        override fun Update(batt_value: Float, Usb: Int) {
        var msg=when (Usb){
            BatteryManager.BATTERY_STATUS_CHARGING -> "Charging"
            BatteryManager.BATTERY_STATUS_DISCHARGING->"Discharging"
            BatteryManager.BATTERY_STATUS_FULL->"Full"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING->"Not charging"
            else-> "I don't know"
        }
           textView.text="$batt_value\n$msg"
            progressBar.progress=batt_value.toInt()
        }
    }

    }


  abstract class Myreceiver:BroadcastReceiver(){
      override fun onReceive(context: Context?, intent: Intent?) {
      var batt_value=intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)?:0
      var batt_max=intent?.getIntExtra(BatteryManager.EXTRA_SCALE,1)?:1
      var batt_level=(batt_value/batt_max.toFloat())*100
          var usb_status=intent?.getIntExtra(BatteryManager.EXTRA_STATUS,0)?:0
          Update(batt_level,usb_status)
      }
      abstract fun Update(batt_value:Float,Usb:Int)
  }
}
