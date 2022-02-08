package com.hamza.Wazaker.Utills;

import static android.content.Context.ALARM_SERVICE;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.hamza.Wazaker.recevier.NotificationReceiver;

import java.util.Calendar;

public class Notifications {

    public static void addNotification(Context context) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        @SuppressLint("UnspecifiedImmutableFlag")
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        setbuilder(alarmManager, pendingIntent, calendar);
    }

    private static void setbuilder(AlarmManager alarmManager, PendingIntent pendingIntent, Calendar calendar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }


}
