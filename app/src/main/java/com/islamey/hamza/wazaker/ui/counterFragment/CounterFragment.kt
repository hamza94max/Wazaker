package com.islamey.hamza.wazaker.ui.counterFragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.islamey.wazkar.R
import com.islamey.wazkar.databinding.CounterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CounterFragment : Fragment() {

    private lateinit var binding: CounterBinding

    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_counter, container, false)
        binding.counterViewModel = counterViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.counter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

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