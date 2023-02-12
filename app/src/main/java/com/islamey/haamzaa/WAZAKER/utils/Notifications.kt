package com.islamey.haamzaa.WAZAKER.utils

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.islamey.haamzaa.WAZAKER.ui.NotificationReceiver
import java.util.*

object Notifications {


    fun setupNotification(context: Context) {
        val cal = Calendar.getInstance()
        cal.timeInMillis = System.currentTimeMillis()
        cal[Calendar.HOUR_OF_DAY] = 17
        cal[Calendar.MINUTE] = 0
        cal[Calendar.SECOND] = 0
        if (cal.timeInMillis > System.currentTimeMillis()) {
            val notificationIntent = Intent(context, NotificationReceiver::class.java)
            @SuppressLint("UnspecifiedImmutableFlag") val broadcast = PendingIntent.getBroadcast(
                context,
                0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                cal.timeInMillis,
                (24 * 60 * 60 * 1000).toLong(), // Repeat every 24 h
                broadcast
            )
        }
    }
}