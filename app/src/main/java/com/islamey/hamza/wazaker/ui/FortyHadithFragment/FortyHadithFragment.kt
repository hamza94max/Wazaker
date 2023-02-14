package com.islamey.hamza.wazaker.ui.FortyHadithFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamey.hamza.wazaker.data.DataSets.FortyDataSet
import com.islamey.hamza.wazaker.data.Models.Hadith
import com.islamey.wazkar.databinding.FragmentFortyHadithBinding

class FortyHadithFragment : Fragment() {

    private var _binding: FragmentFortyHadithBinding? = null
    val binding get() = _binding!!

    lateinit var Hadiths: ArrayList<Hadith>

    private val args: FortyHadithFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFortyHadithBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {

        val adapter =
            HadithAdapter(FortyDataSet.getFortyHadithList(args.intent) as ArrayList<Hadith>)

        val layoutManager = LinearLayoutManager(context)
        binding.fortyHadithList.layoutManager = layoutManager
        binding.fortyHadithList.adapter = adapter
    }

}