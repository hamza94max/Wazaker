package com.islamey.hamza.wazaker.ui

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.islamey.hamza.wazaker.data.DataSets.NotificationDataset
import com.islamey.wazkar.R

class NotificationReceiver : BroadcastReceiver() {

    private val CHANNEL_ID = "Channel 1"

    @Suppress("DEPRECATION")
    override fun onReceive(context: Context, intent1: Intent) {

        val notificationIntent = Intent(context, MainActivity::class.java)
        val stackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addParentStack(MainActivity::class.java)
        stackBuilder.addNextIntent(notificationIntent)

        val pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = Notification.Builder(context)

        val notification: Notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("وذكر")
            .setContentText(NotificationDataset.randomNotification)
            .setSmallIcon(R.drawable.splash)
            .setLights(Notification.FLAG_SHOW_LIGHTS, 1000, 500)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setStyle(NotificationCompat.BigTextStyle())
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID)
        }

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Channel_ID",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.enableLights(true)
            channel.enableVibration(false)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, notification)
    }

}