package com.hamza.Wazaker.ui.Fragments.ZekerAndDoaaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.Wazaker.Data.DataSets.ZekerDataSet
import com.hamza.Wazaker.Data.Models.AzkarListModel
import com.hamza.wazkar.databinding.FragmentZekerAndDoaaBinding
import java.util.*

class ZekerAndDoaaFragment : Fragment() {

    var _binding: FragmentZekerAndDoaaBinding? = null
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

        val layoutManager = LinearLayoutManager(context)
        binding.azkarAndDoaaRec.layoutManager = layoutManager
        binding.azkarAndDoaaRec.adapter =
            ZekerAndDoaaAdapter(ZekerDataSet.getZekerList(args.zekerintent) as ArrayList<AzkarListModel>?)

    }



}