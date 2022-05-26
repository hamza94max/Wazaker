package com.islamic.Wazaker.ui.Activities.MainActivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.islamic.Wazaker.Utills.Notifications.setupAfternoonNotification
import com.islamic.wazkar.R
import com.islamic.wazkar.databinding.ActivityMainBinding
import com.suke.widget.SwitchButton

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAfternoonNotification(this)

    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        val itemSwitch: MenuItem = menu?.findItem(R.id.switch_action_bar)!!
        itemSwitch.setActionView(R.layout.switch_layout)

        val sw =
            menu.findItem(R.id.switch_action_bar).actionView.findViewById(R.id.Main_switch) as SwitchButton

        sw.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

        return true
    }
}

