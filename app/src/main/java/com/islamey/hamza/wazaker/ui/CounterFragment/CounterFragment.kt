package com.islamey.hamza.wazaker.ui.CounterFragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.islamey.hamza.wazaker.utils.RandomColor.getRandomColor
import com.islamey.hamza.wazaker.utils.Utils.getTotalCounts
import com.islamey.hamza.wazaker.utils.Utils.saveTotalCountsInSharedPreference
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    private var counts = 0
    private var totalCounts = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentCounterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    private fun initUi() {

        getDataFromSharedPreferences()

        binding.counterScreenLayout.setOnClickListener {
            incrementCounter()
        }

        binding.resetbtn.setOnClickListener {
            resetCounter()
        }
    }

    @SuppressLint("SetTextI18n")
    fun getDataFromSharedPreferences() {
        totalCounts = context?.let { getTotalCounts(it) }!!
        setTotalZekerCountsText(totalCounts)
    }

    @SuppressLint("SetTextI18n")
    fun setTotalZekerCountsText(TotalZekerCounts: Int) {
        binding.totalCountstextview.text = getString(R.string.totalzeker) + "  " + TotalZekerCounts
    }

    private fun incrementCounter() {
        counts++
        totalCounts++

        checkCounts(counts)
        binding.countertextview.text = counts.toString()
        setTotalZekerCountsText(totalCounts)

        saveTotalCountsInSharedPreference(requireContext(), totalCounts)
    }

    private fun resetCounter() {
        counts = 0
        binding.countertextview.text = counts.toString()
        binding.countertextview.setTextColor(Color.WHITE)
    }

    private fun checkCounts(counts: Int) {
        if (counts % 33 == 0) binding.countertextview.setTextColor(getRandomColor())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.counter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @SuppressLint("SetTextI18n", "NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.delete) {
            resetTotalCounter()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun resetTotalCounter() {
        resetCounter()
        totalCounts = 0
        setTotalZekerCountsText(totalCounts)
        saveTotalCountsInSharedPreference(requireContext(), totalCounts)
        Toast.makeText(context, getString(R.string.TotalDeleted), Toast.LENGTH_SHORT).show()
    }

}