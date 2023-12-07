package com.islamey.hamza.wazaker.ui.HomeFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.islamey.hamza.wazaker.domain.Models.HijriDateResponse
import com.islamey.hamza.wazaker.utils.Ext.hide
import com.islamey.hamza.wazaker.utils.Ext.show
import com.islamey.hamza.wazaker.utils.Utils.getCurrentDate
import com.islamey.hamza.wazaker.utils.Utils.getTotalCounts
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import org.apache.commons.lang3.StringEscapeUtils

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

    @SuppressLint("SetTextI18n")
    private fun setTotalZekerCountsText() {
        binding.totalZekercounts.text = getString(R.string.totalzeker) + "  " + totalcounts
    }


    private fun observeResponse() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            hijriViewModel.hijriDate.collect { state ->
                when (state) {
                    is DataState.Idle -> {
                        binding.hijriCardView.hide()
                    }
                    is DataState.Loading -> {
                        binding.hijriCardView.hide()
                    }
                    is DataState.Success -> {
                        binding.hijriCardView.show()
                        updateUi(state.data)
                    }
                    is DataState.Error -> {
                        Log.e("hamzaError", state.message)
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUi(response: HijriDateResponse) {
        binding.hijriDateTextView.text = buildString {
            append(StringEscapeUtils.unescapeJava(response.data.hijri.weekday.ar))
            append(" ")
            append(response.data.hijri.day)
            append(" ")
            append(StringEscapeUtils.unescapeJava(response.data.hijri.month.ar))
            append(" ")
            append(StringEscapeUtils.unescapeJava(response.data.hijri.year))
            append(" ")
            append("هجريا")
        }

        binding.gregorianDateTextView.text = response.data.gregorian.date
    }


}