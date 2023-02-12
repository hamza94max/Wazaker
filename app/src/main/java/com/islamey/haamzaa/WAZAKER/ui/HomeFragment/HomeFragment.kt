package com.islamey.haamzaa.WAZAKER.ui.HomeFragment

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hassanjamil.hqibla.CompassActivity
import com.hassanjamil.hqibla.Constants
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val MY_PREFS_NAME = "pref"
    private var sharedPreferences: SharedPreferences? = null
    private var totalcounts = 0

    override fun onStart() {
        super.onStart()
        getTotalZekerCountsFromSharedPreferences()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        sharedPreferences =
            context?.getSharedPreferences(MY_PREFS_NAME, AppCompatActivity.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.morningAzkarbtn.setOnClickListener {
            val action = HomeFragmentDirections.actionMainFragmentToMorningAzkarFragment()
            findNavController().navigate(action)
        }

        binding.eveningAzkarbtn.setOnClickListener {
            val action = HomeFragmentDirections.actionMainFragmentToEveningAzkarFragment()
            findNavController().navigate(action)
        }

        binding.azkarsBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionMainFragmentToAzkarFragment()
            findNavController().navigate(action)
        }

        binding.fortyHadithbtn.setOnClickListener {
            val action = HomeFragmentDirections.actionMainFragmentToFortyHadithListFragment()
            findNavController().navigate(action)
        }

        binding.counterBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionMainFragmentToCounterFragment()
            findNavController().navigate(action)
        }

        binding.qiblaBtn.setOnClickListener {
            openQiblaActivity()
        }

    }

    private fun getTotalZekerCountsFromSharedPreferences() {
        totalcounts = sharedPreferences!!.getInt("zekertotalcounts", 0)
        setTotalzekerCountstext()
    }

    @SuppressLint("SetTextI18n")
    private fun setTotalzekerCountstext() {
        binding.totalZekercounts.text = getString(R.string.totalzeker) + "  " + totalcounts
    }

    fun openQiblaActivity() {
        val intent = Intent(context, CompassActivity::class.java)
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