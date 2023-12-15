package com.islamey.hamza.wazaker.ui.FortyHadithListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.islamey.hamza.wazaker.domain.DataSets.FortyListDataset
import com.islamey.hamza.wazaker.ui.OnItemListener
import com.islamey.wazkar.databinding.FragmentFortyHadithListBinding

class FortyHadithListFragment : Fragment(), OnItemListener {

    private var _binding: FragmentFortyHadithListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFortyHadithListBinding.inflate(layoutInflater, container, false)

        setUpFortyHadithListRecyclerView()

        return binding.root
    }

    private fun setUpFortyHadithListRecyclerView() {
        val adapter = FortyHadithListAdapter(this)
        binding.hadithListRecyclerView.adapter = adapter
        adapter.differ.submitList(FortyListDataset.getFortylist())
    }

    override fun onItemCLicked(item: Int) {
        val action =
            FortyHadithListFragmentDirections.actionFortyHadithListFragmentToFortyHadithFragment(
                item
            )
        findNavController().navigate(action)
    }

}