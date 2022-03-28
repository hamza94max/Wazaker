package com.hamza.Wazaker.ui.Activities.MainActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.hamza.Wazaker.Worker.NotificationWorker
import com.hamza.wazkar.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    private val workManager = WorkManager.getInstance(this.application)

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //fireWorkerTodisplayNotification()
    }

    /**
     * display notification every 8 hours
     */
    @SuppressLint("EnqueueWork")
    private fun fireWorkerTodisplayNotification() {
        val workRequest =
            PeriodicWorkRequest.Builder(NotificationWorker::class.java, 8, TimeUnit.HOURS)
                .setInitialDelay(8, TimeUnit.HOURS)
                .build()
        workManager.enqueueUniquePeriodicWork(
            "worker",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }

}

