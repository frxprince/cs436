package com.drpaween.waterdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 var conn=MyDatabase(this,"water.sqlite",null,1)
        var DB=conn.writableDatabase
button.setOnClickListener {
var meter_id=editText.text.toString()
var meter_value=editText2.text.toString()
DB.execSQL("insert into waterdata(meter_id,meter_value) values($meter_id,$meter_value)")
 editText.setText("")
    editText2.setText("")
}

button2.setOnClickListener {
    var i= Intent(this,Report::class.java)
    startActivity(i)
/*    var cursor=DB.rawQuery("select * from waterdata",null)
    while (cursor.moveToNext()){
 Log.v("my database","${cursor.getString(0)}: " +
         "${cursor.getString(1)}: ${cursor.getString(2)}:" +
         "${cursor.getString(3)}")
    }

 */
}

    }
}
