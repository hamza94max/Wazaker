package com.islamey.hamza.wazaker.ui.ZekerAndDoaaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.islamey.hamza.wazaker.domain.DataSets.ZekerDataSet
import com.islamey.hamza.wazaker.domain.Models.AzkarListModel
import com.islamey.wazkar.databinding.FragmentZekerAndDoaaBinding

class ZekerAndDoaaFragment : Fragment() {

    private var _binding: FragmentZekerAndDoaaBinding? = null
    val binding get() = _binding!!

    private val args: ZekerAndDoaaFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentZekerAndDoaaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAzkarAndDoaaRecyclerView()
    }

    private fun setUpAzkarAndDoaaRecyclerView() {
        val adapter = ZekerAndDoaaAdapter()
        binding.azkarAndDoaaRecyclerView.adapter = adapter
        adapter.differ.submitList(ZekerDataSet.getZekerList(args.zekerintent) as ArrayList<AzkarListModel>?)
    }

}
