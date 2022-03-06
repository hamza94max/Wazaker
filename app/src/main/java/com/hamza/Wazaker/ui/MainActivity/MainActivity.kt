package com.hamza.Wazaker.ui.MainActivity

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.hamza.Wazaker.Worker.NotificationWorker
import com.hamza.wazkar.R
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val MY_PREFS_NAME = "MyPrefsFile"

    private var sharedPreferences: SharedPreferences? = null

    private var totalcounts = 0
    private val workManager = WorkManager.getInstance(this.application)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)

        fireWorkerTodisplayNotification()
    }

    /**
     * display notification every 8 hours
     */
    @SuppressLint("EnqueueWork")
    private fun fireWorkerTodisplayNotification() {
        val WorkRequest =
            PeriodicWorkRequest.Builder(NotificationWorker::class.java, 8, TimeUnit.HOURS)
                .setInitialDelay(8, TimeUnit.HOURS)
                .build()
        workManager.enqueueUniquePeriodicWork(
            "worker",
            ExistingPeriodicWorkPolicy.KEEP,
            WorkRequest
        )
    }

//    fun getTotalZekerCountsfromSharedPreferences(){
//        totalcounts = sharedPreferences!!.getInt("zekertotalcounts", 0)
//        setTotalzekerCountstext()
//    }

//    @SuppressLint("SetTextI18n")
//    fun setTotalzekerCountstext() {
//        //binding!!.totalZekercounts.text = getString(R.string.totalzeker) + "  " + totalcounts
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
//    fun openQiblaActivity(view: View?) {
//        val intent = Intent(this@MainActivity, CompassActivity::class.java)
//        intent.putExtra(Constants.TOOLBAR_BG_COLOR, "#FFFFFF") // Toolbar Background color
//        intent.putExtra(Constants.COMPASS_BG_COLOR, "#FFFFFF") // Compass background color
//        intent.putExtra(Constants.ANGLE_TEXT_COLOR, "#000000") // Angle Text color
//        intent.putExtra(Constants.DRAWABLE_DIAL, R.drawable.dial) // Your dial drawable resource
//        intent.putExtra(
//            Constants.DRAWABLE_QIBLA,
//            R.drawable.qibla
//        ) // Your qibla indicator drawable resource
//        intent.putExtra(
//            Constants.FOOTER_IMAGE_VISIBLE,
//            View.VISIBLE or View.INVISIBLE or View.GONE
//        ) // Footer World Image visibility
//        intent.putExtra(
//            Constants.LOCATION_TEXT_VISIBLE,
//            View.VISIBLE or View.INVISIBLE or View.GONE
//        ) // Location Text visibility
//        startActivity(intent)
//    }
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

