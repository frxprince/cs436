package com.drpaween.waterdatabase

import android.app.ListActivity
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter

class Report : ListActivity() {
lateinit var DB:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        var conn=MyDatabase(this,"water.sqlite",null,1)
        DB=conn.writableDatabase
        PaintGrid()
    }

    fun PaintGrid(){
 var cursor=DB.rawQuery("select id as _id,meter_id,meter_value,timestamp from waterdata",
     null)
 var columns= arrayOf("meter_id","meter_value","timestamp")
 var map_to= intArrayOf(R.id.textView6,R.id.textView7,R.id.textView8)
 var myadapter=SimpleCursorAdapter(this,R.layout.listview_item,cursor,columns,map_to,0)
listAdapter=myadapter
 }
}
