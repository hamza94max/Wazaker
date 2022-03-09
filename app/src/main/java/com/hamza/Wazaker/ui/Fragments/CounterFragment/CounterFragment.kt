package com.hamza.Wazaker.ui.Fragments.CounterFragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hamza.Wazaker.Utills.RandomColor
import com.hamza.wazkar.R
import com.hamza.wazkar.databinding.FragmentCounterBinding


class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private val MY_PREFS_NAME = "pref"
    private var sharedPreferences: SharedPreferences? = null

    private var counter = 0
    private var totalCounts = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCounterBinding.inflate(layoutInflater, container, false)

        getDatafromSharedPreferences()

        binding.counterscreen.setOnClickListener {
            counter++
            totalCounts++

            checkcounts(counter)
            binding.countertextview.text = counter.toString()
            setTotalzekerCountstext(totalCounts)

            saveTotalcountsInSharedPreference()
        }

        binding.resetbtn.setOnClickListener {
            counter = 0
            binding.countertextview.text = counter.toString()
            binding.countertextview.setTextColor(Color.WHITE)
        }


        return binding.root
    }

    @SuppressLint("SetTextI18n")
    fun getDatafromSharedPreferences() {
        sharedPreferences = context?.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE)
        totalCounts = sharedPreferences!!.getInt("zekertotalcounts", totalCounts)
        setTotalzekerCountstext(totalCounts)
    }

    @SuppressLint("SetTextI18n")
    fun setTotalzekerCountstext(Totalzekercounts: Int) {
        binding.totalCountstextview.text = getString(R.string.totalzeker) + "  " + Totalzekercounts
    }

    private fun checkcounts(counts: Int) {
        if (counts % 33 == 0) getRandomcolor()
    }

    private fun getRandomcolor() {
        val currentColor: Int
        if (counter % 33 == 0) {
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
            setTotalzekerCountstext(totalCounts)
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