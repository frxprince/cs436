package com.drpaween.findprimekservice

import android.app.IntentService
import android.content.Intent
import android.content.Context
import androidx.core.content.ContextCompat

class PrimeIntentService : IntentService("PrimeIntentService") {
 var intent_progress=Intent()
    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            "start" -> {
                val param1 = intent.getLongExtra("k",0)
                handleActionStart(param1)
            }
        }
    }

    private fun handleActionStart(param1: Long) {
var i=Intent(this,MainActivity::class.java)
i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
i.addFlags((Intent.FLAG_ACTIVITY_SINGLE_TOP))


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
                if(c==k)
                    return i
            }
                i++
            }
        }
        var Result=FindPrimeK(param1)
        i.putExtra("result",Result)
        ContextCompat.startActivity(this,i,null)
        ContextCompat.startActivity(this,i,null)
        intent_progress.setAction("com.drpaween.findprimekservice")
        intent_progress.putExtra("result",Result)
        sendBroadcast(intent_progress)
    }


}
