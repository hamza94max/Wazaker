package com.islamey.hamza.wazaker.ui.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.islamey.hamza.wazaker.utils.Utils.getDarkModeState
import com.islamey.hamza.wazaker.utils.Utils.saveDarkModeState
import com.islamey.wazkar.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()


    }

    private fun initUi() {
        binding.contactUsLinearLayout.setOnClickListener {
            contactUs()
        }

        binding.darkModeSwitch.isChecked = getDarkModeState(requireContext())

        binding.darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                saveDarkModeState(requireContext(), true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                saveDarkModeState(requireContext(), false)
            }
        }


    }

    private fun contactUs() {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://api.whatsapp.com/send?phone=+201065628949&text=")
                )
            )
        } catch (e: Exception) {
            Toast.makeText(context, "whatsapp app not install", Toast.LENGTH_LONG).show()
        }
    }


}