package com.drpaween.bytesconversion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        setContentView(R.layout.activity_third)
        var i= Intent()
        var animation=AnimationUtils.loadAnimation(this,R.anim.blink)
        button3.startAnimation(animation)

        button3.setOnClickListener(){
            i.putExtra("data","kb")
            setResult(Activity.RESULT_OK,i)
            finish()
        } //kb
        button4.setOnClickListener(){
            i.putExtra("data","mb")
            setResult(Activity.RESULT_OK,i)
            finish()
        } //mb
        button5.setOnClickListener(){
            i.putExtra("data","gb")
            setResult(Activity.RESULT_OK,i)
            finish()
        } //gb
    }
}
