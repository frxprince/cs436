package com.drpaween.preference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button3.setOnClickListener { finish() }
        button.setOnClickListener {
            var config=getSharedPreferences("my_config", Context.MODE_PRIVATE)
            config.edit {
                putString("key1",editText.text.toString())
                putString("key2",editText2.text.toString())
                commit()
            }
        }
        button2.setOnClickListener {
            var config=getSharedPreferences("my_config",Context.MODE_PRIVATE)
            var c=config.all
            editText.setText(config.getString("key1","default1"))
            editText2.setText(config.getString("key2","default2"))
            //editText.setText(c.get("key1").toString())
            //editText2.setText(c.get("key2").toString())
        }
    }
}
