package com.islamey.haamzaa.WAZAKER.ui.FortyHadithListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.islamey.haamzaa.WAZAKER.data.DataSets.FortyListDataset
import com.islamey.haamzaa.WAZAKER.data.Models.AzkarListModel
import com.islamey.haamzaa.WAZAKER.ui.OnItemListener
import com.islamey.wazkar.databinding.FragmentFortyHadithListBinding


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

        fortyAdapter.setListner(object : OnItemListener {
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