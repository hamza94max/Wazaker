package com.islamey.hamza.wazaker.ui.EveningAzkarFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.islamey.hamza.wazaker.domain.DataSets.EveningAzkarDataset
import com.islamey.wazkar.databinding.FragmentEveningAzkarBinding

class EveningAzkarFragment : Fragment() {

    private lateinit var binding: FragmentEveningAzkarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEveningAzkarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpEveningAzkarRecyclerView()
    }

    private fun setUpEveningAzkarRecyclerView() {
        val adapter = EveningAzkarAdapter()
        binding.eveningRecyclerView.adapter = adapter
        adapter.differ.submitList(EveningAzkarDataset.getEveningAzkar())
    }
}