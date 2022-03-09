package com.hamza.Wazaker.ui.Fragments.FortyHadithListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hamza.Wazaker.Data.Data_sets.FortyListDataset
import com.hamza.Wazaker.Data.Models.AzkarListModel
import com.hamza.Wazaker.ui.listeners.ItemListner
import com.hamza.wazkar.databinding.FragmentFortyHadithListBinding
import java.util.*


class FortyHadithListFragment : Fragment() {

    private var _binding: FragmentFortyHadithListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentFortyHadithListBinding.inflate(layoutInflater, container, false)

        getFortyHadithData()

        return binding.root
    }


    private fun getFortyHadithData() {
        val hadithlist = FortyListDataset.getFortylist()
        val fortyAdapter = FortyListAdapter(
            hadithlist as ArrayList<AzkarListModel?>
        )
        binding.hadithrecycler.adapter = fortyAdapter

        fortyAdapter.setListner(object : ItemListner {
            override fun onItemCLicked(item: Any?) {
                val index = item as Int
                val action =
                    FortyHadithListFragmentDirections.actionFortyHadithListFragmentToFortyHadithFragment(
                        index
                    )
                findNavController().navigate(action)
            }
        })
    }

}