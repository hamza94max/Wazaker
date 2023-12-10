package com.islamey.hamza.wazaker.ui.HomeFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.islamey.hamza.wazaker.domain.Models.HijriDateResponse
import com.islamey.hamza.wazaker.utils.Utils.getCurrentDate
import com.islamey.hamza.wazaker.utils.Utils.getFormattedHijriDate
import com.islamey.hamza.wazaker.utils.Utils.getTotalCounts
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val hijriViewModel: HijriViewModel by viewModels()

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

        hijriViewModel.getHijriDate(getCurrentDate())

        initUI()

        observeResponse()
    }

    private fun initUI() {
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

    private fun setTotalZekerCountsText() {
        binding.totalZekercounts.text = getString(R.string.totalzeker) + "  " + totalcounts
    }

    private fun observeResponse() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            hijriViewModel.hijriDate.collect { state ->
                when (state) {
                    is DataState.Idle -> {
                        binding.hijriCardView.isVisible = false
                    }
                    is DataState.Loading -> {
                        binding.hijriCardView.isVisible = false
                    }
                    is DataState.Success -> {
                        binding.hijriCardView.isVisible = true
                        updateUi(state.data)
                    }
                    is DataState.Error -> {
                        Log.e("hamzaError", state.message)
                    }
                }
            }
        }
    }

    private fun updateUi(response: HijriDateResponse) {
        binding.hijriDateTextView.text = getFormattedHijriDate(response)
        binding.gregorianDateTextView.text = response.data.gregorian.date
    }


}