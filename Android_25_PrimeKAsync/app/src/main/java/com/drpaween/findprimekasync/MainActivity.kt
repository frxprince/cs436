package com.drpaween.findprimekasync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 button.setOnClickListener {
     doAsync {
         fun isPrime(x:Long):Boolean{
             for (i in 2..x-1)
             {
                 if((x%i)==0L)
                     return false
             }
             return true
         }
         fun FindPrimeK(k:Long):Long{
             var i=3L
             var c=0L
             while (true)
             {  if(isPrime(i))
             {  c++
               uiThread { textView2.text=c.toString() }
                 if(c==k)
                     return i
             }
                 i++
             }
         }
      var result=FindPrimeK(editText.text.toString().toLong())
         uiThread { textView.text=result.toString() }
     }
 }
    }
}
