package com.hamza.Wazaker.ui.MainActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.WorkManager
import com.hamza.wazkar.databinding.ActivityMainBinding

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

//    /**
//     * display notification every 8 hours
//     */
//    @SuppressLint("EnqueueWork")
//    private fun fireWorkerTodisplayNotification() {
//        val WorkRequest =
//            PeriodicWorkRequest.Builder(NotificationWorker::class.java, 8, TimeUnit.HOURS)
//                .setInitialDelay(8, TimeUnit.HOURS)
//                .build()
//        workManager.enqueueUniquePeriodicWork(
//            "worker",
//            ExistingPeriodicWorkPolicy.KEEP,
//            WorkRequest
//        )
//    }


//
//    fun openCounterActivity(view: View?) {
//        openActivity(CounterActivity::class.java)
//    }
//
//    fun openeveningAzkarActivity(view: View?) {
//        openActivity(EveningAzkarActivity::class.java)
//    }
//
//    fun openMorningAzkarActivity(view: View?) {
//        openActivity(MorningAzkarActivity::class.java)
//    }
//
//    fun openFortyHadithActivity(view: View?) {
//        openActivity(FortyHadithListActivity::class.java)
//    }
//
//    fun openAzkarActivity(view: View?) {
//        openActivity(AzkarListActivity::class.java)
//    }
//
//    fun openActivity(activity: Class<*>?) {
//        val intent = Intent(baseContext, activity)
//        startActivity(intent)
//    }
//
//
//    fun shareApp(view: View?) {
//        try {
//            val shareIntent = Intent(Intent.ACTION_SEND)
//            shareIntent.type = "text/plain"
//            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
//            val shareMessage = """
//                https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
//                """.trimIndent()
//
//            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
//            startActivity(Intent.createChooser(shareIntent, "choose one"))
//        } catch (e: Exception) {
//            Toast.makeText(baseContext, "خلل في مشاركة التطبيق، المرجو الإعادة", Toast.LENGTH_SHORT)
//                .show()
//        }
}

