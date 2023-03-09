package com.islamey.hamza.wazaker.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.islamey.hamza.wazaker.utils.Notifications.setupNotification
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.ActivityMainBinding
import com.suke.widget.SwitchButton

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        





        setupNotification(this)
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        val itemSwitch: MenuItem = menu?.findItem(R.id.switch_action_bar)!!
        itemSwitch.setActionView(R.layout.switch_layout)

        val switchButton =
            menu.findItem(R.id.switch_action_bar).actionView?.findViewById(R.id.Main_switch) as SwitchButton

        switchButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

        return true
    }
}

