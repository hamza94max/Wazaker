package com.islamey.hamza.wazaker.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hassanjamil.hqibla.CompassActivity
import com.hassanjamil.hqibla.Constants
import com.islamey.hamza.wazaker.utils.Notifications.setupNotification
import com.islamey.hamza.wazaker.utils.Utils.getDarkModeState
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navHostFragment.navController
    }

    private var lastOpenedScreenId = R.id.home_action

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDarkModeState()
        setupNotification(this)

        setUpBottomViewNavigation()
    }

    private fun setDarkModeState() {
        if (getDarkModeState(this))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setUpBottomViewNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_action -> {
                    doIfNotCurrent(R.id.home_action){
                        navController.navigate(R.id.homeFragment)
                    }
                    true
                }

                R.id.qibla_action -> {
                    openQiblaActivity()
                    // as we open another activity we should not lose current selection
                    false
                }

                R.id.forty_action -> {
                    doIfNotCurrent(R.id.forty_action){
                        navController.navigate(R.id.fortyHadithListFragment)
                    }
                    true
                }

                R.id.settings_action -> {
                    doIfNotCurrent(R.id.settings_action){
                        navController.navigate(R.id.settingsFragment)
                    }
                    true
                }

                else -> false
            }
        }
    }

    private fun doIfNotCurrent(actionId: Int, action : ()-> Unit) {
        if (actionId != lastOpenedScreenId){
            action.invoke()
            lastOpenedScreenId = actionId
        }
    }

    private fun openQiblaActivity() {
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

