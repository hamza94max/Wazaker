package com.example.wazkar;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentProvider;
import android.content.Intent;
import android.os.Build;

public class Notification extends Application {

String CHANNEL_ID;
    @Override
    public void onCreate() {
        super.onCreate();

        CreateNotificationChannel();
    }

    private void CreateNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel Channel1 =new NotificationChannel(CHANNEL_ID,"Wazkar وذكر"
                    , NotificationManager.IMPORTANCE_HIGH);

            Channel1.setDescription("Wazkar وذكر");
            NotificationManager manager=getSystemService(NotificationManager.class);

            manager.createNotificationChannel(Channel1);


    }


}}
