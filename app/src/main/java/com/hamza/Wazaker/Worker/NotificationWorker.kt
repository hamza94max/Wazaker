package com.hamza.Wazaker.Worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.hamza.Wazaker.Utills.Notifications

class NotificationWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        Notifications.addNotification(applicationContext)
        return Result.success()
    }
}