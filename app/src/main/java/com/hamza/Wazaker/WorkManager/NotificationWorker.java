package com.hamza.Wazaker.WorkManager;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.hamza.Wazaker.Utills.Notifications;

public class NotificationWorker extends Worker {

    public NotificationWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Notifications.addNotification(getApplicationContext());
        return Result.success();
    }
}








