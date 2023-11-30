package com.islamey.hamza.wazaker.ui.HomeFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.islamey.hamza.wazaker.utils.Utils.getTotalCounts
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var totalcounts = 0

    override fun onStart() {
        super.onStart()
        getTotalZekerCountsFromSharedPreferences()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

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

        binding.counterBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionMainFragmentToCounterFragment()
            findNavController().navigate(action)
        }

    }

    private fun getTotalZekerCountsFromSharedPreferences() {
        totalcounts = getTotalCounts(requireContext())
        setTotalZekerCountsText()
    }

    @SuppressLint("SetTextI18n")
    private fun setTotalZekerCountsText() {
        binding.totalZekercounts.text = getString(R.string.totalzeker) + "  " + totalcounts
    }


}