package com.islamey.hamza.wazaker.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hassanjamil.hqibla.CompassActivity
import com.hassanjamil.hqibla.Constants
import com.islamey.hamza.wazaker.utils.Notifications.setupNotification
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNotification(this)

        setUpBottomViewNavigation()


    }

    private fun setUpBottomViewNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.home_action -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.qibla_action -> {
                    openQiblaActivity()
                    true
                }

                R.id.forty_action -> {
                    navController.navigate(R.id.fortyHadithListFragment)
                    true
                }

                R.id.settings_action -> {
                    navController.navigate(R.id.settingsFragment)
                    true
                }

                else -> false
            }
        }
    }


    fun openQiblaActivity() {
        val intent = Intent(this, CompassActivity::class.java)
        intent.putExtra(Constants.TOOLBAR_BG_COLOR, "#FFFFFF") // Toolbar Background color
        intent.putExtra(Constants.COMPASS_BG_COLOR, "#FFFFFF") // Compass background color
        intent.putExtra(Constants.ANGLE_TEXT_COLOR, "#000000") // Angle Text color
        intent.putExtra(Constants.DRAWABLE_DIAL, R.drawable.dial) // Your dial drawable resource
        intent.putExtra(
            Constants.DRAWABLE_QIBLA,
            R.drawable.qibla
        ) // Your qibla indicator drawable resource
        intent.putExtra(
            Constants.FOOTER_IMAGE_VISIBLE,
            View.VISIBLE or View.INVISIBLE or View.GONE
        ) // Footer World Image visibility
        intent.putExtra(
            Constants.LOCATION_TEXT_VISIBLE,
            View.VISIBLE or View.INVISIBLE or View.GONE
        ) // Location Text visibility
        startActivity(intent)
    }

}

