package com.islamey.hamza.wazaker.ui.MorningAzkarFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamey.hamza.wazaker.data.DataSets.MorningAzkarDataset
import com.islamey.hamza.wazaker.data.Models.ZekerModel
import com.islamey.wazkar.databinding.FragmentMorningAzkarBinding

class MorningAzkarFragment : Fragment() {

    private var _binding: FragmentMorningAzkarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMorningAzkarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        binding.morRecyclerview.layoutManager = layoutManager

        val adapter =
            MorningAzkarAdapter(
                MorningAzkarDataset.morningAzkar as ArrayList<ZekerModel>?
            )
        binding.morRecyclerview.adapter = adapter

    }

}