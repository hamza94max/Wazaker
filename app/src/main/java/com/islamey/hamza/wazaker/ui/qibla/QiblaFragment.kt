package com.islamey.hamza.wazaker.ui.qibla

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hassanjamil.hqibla.CompassActivity
import com.hassanjamil.hqibla.Constants
import com.islamey.wazkar.databinding.FragmentQiblaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QiblaFragment : Fragment() {

    private var _binding: FragmentQiblaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQiblaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openQiblaActivity()
    }

    private fun openQiblaActivity() {
        val intent = Intent(requireContext(), CompassActivity::class.java)
        intent.putExtra(Constants.TOOLBAR_BG_COLOR, "#FFFFFF") // Toolbar Background color
        intent.putExtra(Constants.COMPASS_BG_COLOR, "#FFFFFF") // Compass background color
        intent.putExtra(Constants.ANGLE_TEXT_COLOR, "#000000") // Angle Text color
        startActivity(intent)
    }
}