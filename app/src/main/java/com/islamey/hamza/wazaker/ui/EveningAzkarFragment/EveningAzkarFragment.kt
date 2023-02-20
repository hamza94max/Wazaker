package com.islamey.hamza.wazaker.ui.EveningAzkarFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamey.hamza.wazaker.data.DataSets.EveningAzkarDataset
import com.islamey.hamza.wazaker.data.Models.ZekerModel
import com.islamey.wazkar.databinding.FragmentEveningAzkarBinding


class EveningAzkarFragment : Fragment() {

    private var _binding: FragmentEveningAzkarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEveningAzkarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        binding.eveningrecycler.layoutManager = layoutManager

        val adapter =
            EveningAzkarAdapter(
                EveningAzkarDataset.getEveningAzkar() as ArrayList<ZekerModel>?
            )

        binding.eveningrecycler.layoutManager = layoutManager
        binding.eveningrecycler.adapter = adapter


    }
}