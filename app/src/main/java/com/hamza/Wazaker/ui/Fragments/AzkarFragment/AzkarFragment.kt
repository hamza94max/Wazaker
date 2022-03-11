package com.hamza.Wazaker.ui.Fragments.AzkarFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.Wazaker.Data.Data_sets.AzkarListDataset
import com.hamza.Wazaker.ui.Adapters.AzkarListAdapter
import com.hamza.Wazaker.ui.listeners.ItemListner
import com.hamza.wazkar.databinding.FragmentAzkarBinding

class AzkarFragment : Fragment() {

    var _binding: FragmentAzkarBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentAzkarBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        val layoutManager = LinearLayoutManager(context)
        binding.AzkarListRecycler.layoutManager = layoutManager
        val azkarListAdapter = AzkarListAdapter(AzkarListDataset.getAzkarList())
        binding.AzkarListRecycler.adapter = azkarListAdapter
        azkarListAdapter.setListner(object : ItemListner {
            override fun onItemCLicked(item: Any?) {
//                val index = e as Int
//                val zeker = Intent(context, ZekerActivity::class.java)
//                zeker.putExtra("index", index)
//                startActivity(zeker)
            }
        })
    }
}