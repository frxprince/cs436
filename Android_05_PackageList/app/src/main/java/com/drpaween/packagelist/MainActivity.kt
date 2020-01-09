package com.drpaween.packagelist

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  var displayList= mutableListOf<String>()
  var packageList=packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        for (item in packageList)
        {
         Log.v("my Install Package",item.packageName )
          displayList.add(item.packageName)
        }
  var adapter=ArrayAdapter(this,R.layout.layout_listitem,displayList.toTypedArray())
  listview.adapter=adapter

   listview.setOnItemClickListener(){ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
       textView.text= displayList[i]
  if(packageManager.getLaunchIntentForPackage(displayList[i])!=null){
      button.isEnabled=true
      textView2.text=packageManager.getApplicationLabel(
          packageManager.getApplicationInfo(displayList[i],0)).toString()+"\n"+
          packageManager.getLaunchIntentForPackage(displayList[i]).toString()
  }else{
      button.isEnabled=false
      textView2.text="no launch intent"
  }
   }
        button.setOnClickListener(){
      var i=packageManager.getLaunchIntentForPackage(textView.text.toString())
            startActivity(i)
        }
    }
}
