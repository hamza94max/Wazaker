package com.islamey.hamza.wazaker.ui.AzkarListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.islamey.hamza.wazaker.domain.DataSets.AzkarListDataset
import com.islamey.hamza.wazaker.ui.OnItemListener
import com.islamey.wazkar.databinding.FragmentAzkarBinding

class AzkarListFragment : Fragment(), OnItemListener {

    private var _binding: FragmentAzkarBinding? = null
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

        setUpAzkarListRecyclerView()
    }

    private fun setUpAzkarListRecyclerView() {

        val adapter = AzkarListAdapter(this)

        binding.azkarListRecyclerView.adapter = adapter
        adapter.differ.submitList(AzkarListDataset.getAzkarList(requireContext()))
    }

    override fun onItemCLicked(item: Int) {
        val action =
            AzkarListFragmentDirections.actionAzkarFragmentToZekerAndDoaaFragment(item)
        findNavController().navigate(action)
    }
}