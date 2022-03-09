package com.hamza.Wazaker.ui.Fragments.MainFragment

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
import com.hamza.wazkar.R
import com.hamza.wazkar.databinding.FragmentMainBinding
import com.hassanjamil.hqibla.CompassActivity
import com.hassanjamil.hqibla.Constants


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val MY_PREFS_NAME = "pref"
    private var sharedPreferences: SharedPreferences? = null
    private var totalcounts = 0


    override fun onStart() {
        super.onStart()
        getTotalZekerCountsfromSharedPreferences()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        sharedPreferences =
            context?.getSharedPreferences(MY_PREFS_NAME, AppCompatActivity.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.counterBtn.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToCounterFragment()
            findNavController().navigate(action)
        }

        binding.qiblaBtn.setOnClickListener {
            openQiblaActivity()
        }

    }

    fun getTotalZekerCountsfromSharedPreferences() {
        totalcounts = sharedPreferences!!.getInt("zekertotalcounts", 0)
        setTotalzekerCountstext()
    }

    @SuppressLint("SetTextI18n")
    fun setTotalzekerCountstext() {
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