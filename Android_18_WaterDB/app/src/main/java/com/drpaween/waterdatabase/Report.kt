package com.drpaween.waterdatabase

import android.Manifest
import android.app.ListActivity
import android.content.pm.PackageManager
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_report.*
import java.io.File
import java.io.FileOutputStream

class Report : ListActivity() {
lateinit var DB:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        var conn=MyDatabase(this,"water.sqlite",null,1)
        DB=conn.writableDatabase
        PaintGrid()

        button3.setOnClickListener {
            DB.execSQL("update waterdata set meter_id=${editText3.text.toString()}, meter_value=${editText4.text.toString()} where id=$ID")
         PaintGrid()
        }

        button4.setOnClickListener {
            DB.execSQL("delete from waterdata where id=$ID")
            PaintGrid()
        }

   if (ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED)
       ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),1234)

        button5.setOnClickListener {
    var file= File(Environment.getExternalStorageDirectory().path+"/waterdata.csv")
            var outputfile=FileOutputStream(file)
            var cursor=DB.rawQuery("select * from waterdata",null)
            outputfile.write("ID,meter_id,meter_data,timestamp\n".toByteArray())
            while(cursor.moveToNext())
            {
                outputfile.write("${cursor.getString(0)}, ${cursor.getString(1)} ,${cursor.getString(2)} ,${cursor.getString(3)}\n".toByteArray())
                outputfile.flush()
            }
            outputfile.close()
        }
    }
var ID:String=""
    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        var cursor=listAdapter.getItem(position) as Cursor
        editText3.setText(cursor.getString(1))
        editText4.setText(cursor.getString(2))
        ID=cursor.getString(0)
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
