package com.islamey.hamza.wazaker.ui.CounterFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.islamey.hamza.wazaker.utils.RandomColor.getRandomColor
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.FragmentCounterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    private val counterViewModel: CounterViewModel by viewModels()

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

    @SuppressLint("SetTextI18n")
    private fun initUi() {

        lifecycleScope.launch {
            counterViewModel.counts.collect { counts ->
                binding.countertextview.text = counts.toString()
                checkCounts(counts)
            }
        }

        lifecycleScope.launch {
            counterViewModel.totalCounts.collect { totalCounts ->
                binding.totalCountstextview.text =
                    getString(R.string.totalzeker) + "  " + totalCounts.toString()
            }
        }

        binding.counterScreenLayout.setOnClickListener {
            counterViewModel.incrementCounter()
        }

        binding.resetbtn.setOnClickListener {
            counterViewModel.resetCounter()
        }
    }

    private fun checkCounts(counts: Int) {
        if (counts != 0 && counts % 33 == 0) binding.countertextview.setTextColor(getRandomColor())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.counter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @SuppressLint("SetTextI18n", "NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.delete) {
            counterViewModel.resetTotalCounter()
            Toast.makeText(requireContext(), R.string.TotalDeleted, Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}