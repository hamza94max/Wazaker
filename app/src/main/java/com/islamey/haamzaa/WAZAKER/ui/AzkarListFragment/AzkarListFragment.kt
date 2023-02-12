package com.islamey.haamzaa.WAZAKER.ui.AzkarListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamey.haamzaa.WAZAKER.data.DataSets.AzkarListDataset
import com.islamey.haamzaa.WAZAKER.ui.OnItemListener
import com.islamey.wazkar.databinding.FragmentAzkarBinding

class AzkarListFragment : Fragment() {

    var _binding: FragmentAzkarBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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

        val azkarListAdapter =
            AzkarListAdapter(AzkarListDataset.getAzkarList())

        binding.AzkarListRecycler.adapter = azkarListAdapter

        azkarListAdapter.setListner(object : OnItemListener {
            override fun onItemCLicked(item: Any?) {

                val action =
                    AzkarListFragmentDirections.actionAzkarFragmentToZekerAndDoaaFragment(item as Int)
                findNavController().navigate(action)
            }
        })
    }
}