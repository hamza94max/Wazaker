package com.islamey.hamza.wazaker.ui.CounterFragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.islamey.hamza.wazaker.utils.RandomColor
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private val MY_PREFS_NAME = "pref"
    private var sharedPreferences: SharedPreferences? = null

    private var counts = 0
    private var totalCounts = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCounterBinding.inflate(layoutInflater, container, false)

        getDataFromSharedPreferences()

        binding.counterscreen.setOnClickListener {
            counts++
            totalCounts++

            checkCounts(counts)
            binding.countertextview.text = counts.toString()
            setTotalZekerCountstext(totalCounts)

            saveTotalcountsInSharedPreference()
        }

        binding.resetbtn.setOnClickListener {
            counts = 0
            binding.countertextview.text = counts.toString()
            binding.countertextview.setTextColor(Color.WHITE)
        }


        return binding.root
    }

    @SuppressLint("SetTextI18n")
    fun getDataFromSharedPreferences() {
        sharedPreferences = context?.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE)
        totalCounts = sharedPreferences!!.getInt("zekertotalcounts", totalCounts)
        setTotalZekerCountstext(totalCounts)
    }

    @SuppressLint("SetTextI18n")
    fun setTotalZekerCountstext(Totalzekercounts: Int) {
        binding.totalCountstextview.text = getString(R.string.totalzeker) + "  " + Totalzekercounts
    }

    private fun checkCounts(counts: Int) {
        if (counts % 33 == 0) getRandomcolor()
    }

    private fun getRandomcolor() {
        val currentColor: Int
        if (counts % 33 == 0) {
            currentColor = RandomColor.getRandomColor()
            binding.countertextview.setTextColor(currentColor)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.counter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @SuppressLint("SetTextI18n", "NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.delete) {
            totalCounts = 0
            setTotalZekerCountstext(totalCounts)
            saveTotalcountsInSharedPreference()
            Toast.makeText(context, getString(R.string.TotalDeleted), Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveTotalcountsInSharedPreference() {
        val editor = sharedPreferences!!.edit()
        editor.putInt("zekertotalcounts", totalCounts)
        editor.apply()
    }

}