package com.drpaween.findprimek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var worker:PrimeKThread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var k = editText.text.toString().toLong()
            worker=object:PrimeKThread(k){
                override fun ShowResult(x: Long) {
         this@MainActivity.runOnUiThread { textView.text="$x" }
                      }

                override fun ShowProgress(x: Long) {
                    this@MainActivity.runOnUiThread { textView2.text="$x" }
                }

            }
            worker.start()
        }

        button2.setOnClickListener {
            worker.running=false
        }
    }

    abstract class PrimeKThread(val k:Long):Thread(){
        override fun run() {
            super.run()
            val result=FindPrimeK(k)
            Log.v("Result is","$result")
            ShowResult(result)
        }

        abstract fun ShowResult(x:Long)
        abstract fun ShowProgress(x:Long)
        var running=true

        fun isPrime(x: Long): Boolean {
            for (i in 2..x - 1) {
                if ((x % i) == 0L)
                    return false
            }
            return true
        }

        fun FindPrimeK(k: Long): Long {
            var i = 3L
            var c = 0L
            while (running) {
                if (isPrime(i)) {
                    c++
                    ShowProgress(c)
                    if (c == k)
                        return i
                }
                i++
            }
            return -1L
        }
    }




}