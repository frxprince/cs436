package com.drpaween.money

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
lateinit var rate_map:JSONObject
    var currency_list= mutableListOf<String>()
    var THB_TO_EURO=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   fun httpgetdone() {
       this@MainActivity.runOnUiThread {

           var adapter =
               ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, currency_list)
       spinner.adapter=adapter
       spinner.onItemSelectedListener=this
       }
       }
    doAsync {
        var url= URL("https://api.exchangeratesapi.io/latest")
        var conn=url.openConnection() as HttpURLConnection
        conn.requestMethod="GET"
        conn.connect()
        var response=BufferedReader(InputStreamReader(conn.inputStream)).readLine()
        var exchange_rate=JSONObject(response)
        var currency=exchange_rate.getString("rates")
        rate_map=JSONArray("["+currency+"]").getJSONObject(0)
    for(i in rate_map.keys()){
       if (i=="THB")
           THB_TO_EURO=rate_map.getDouble(i)
        currency_list.add(i)
    }

 httpgetdone()
    }}

    override fun onNothingSelected(parent: AdapterView<*>?) {
       }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    var result=(editText.text.toString().toDouble() / THB_TO_EURO) * rate_map.getDouble(
        currency_list[position])
        textView.text="$result"
    }
}
