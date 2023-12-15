package com.islamey.hamza.wazaker.ui.MorningAzkarFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.islamey.hamza.wazaker.domain.DataSets.MorningAzkarDataset
import com.islamey.wazkar.databinding.FragmentMorningAzkarBinding

class MorningAzkarFragment : Fragment() {

    private var _binding: FragmentMorningAzkarBinding? = null
    private val binding get() = _binding!!

    var morningAzkarList = MorningAzkarDataset.morningAzkar.toMutableList()
    lateinit var adapter: MorningAzkarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMorningAzkarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpMorningAzkarRecyclerView()


    }

    private fun setUpMorningAzkarRecyclerView() {
        val adapter = MorningAzkarAdapter()
        binding.morRecyclerview.adapter = adapter
        adapter.differ.submitList(morningAzkarList)
    }


}