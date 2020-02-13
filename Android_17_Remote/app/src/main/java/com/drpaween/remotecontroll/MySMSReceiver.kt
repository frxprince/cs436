package com.drpaween.remotecontroll

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class MySMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
     Log.v("SMS SMS","Received!!!!!!!")
  var msg=Telephony.Sms.Intents.getMessagesFromIntent(intent)[0]
  if (msg.displayMessageBody=="CSMJU"){
      var i=Intent(context,MainActivity::class.java)
      i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      context.startActivity(i)
  }
        if (msg.displayMessageBody=="meaw"){
            var i=Intent(context,MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            i.putExtra("mode","meaw")
            context.startActivity(i)
            context.startActivity(i)
        }
        if (msg.displayMessageBody=="alarm"){
            var i=Intent(context,MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            i.putExtra("mode","alarm")
            context.startActivity(i)
            context.startActivity(i)
        }




    }
}
