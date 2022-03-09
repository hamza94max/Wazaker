package com.hamza.Wazaker.ui.Fragments.FortyHadithFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hamza.Wazaker.Data.Data_sets.FortyDataSet
import com.hamza.wazkar.databinding.FragmentFortyHadithBinding

class FortyHadithFragment : Fragment() {

    private var _binding: FragmentFortyHadithBinding? = null
    val binding get() = _binding!!

    lateinit var Hadiths: Array<String>
    lateinit var Hadithcount: IntArray

    private val args: FortyHadithFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentFortyHadithBinding.inflate(layoutInflater, container, false)

        val dataIndex = args.intent
        LoadData(dataIndex)

        setAdapter()

        binding.copybtn.setOnClickListener {
            val item = Hadiths[binding.viewpager.currentItem]

            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, item)
            sendIntent.type = "text/plain"

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        return binding.root
    }


    private fun LoadData(index: Int) {
        Hadiths = FortyDataSet.getFortyList(index)
        Hadithcount = IntArray(Hadiths.size)
    }

    private fun setAdapter() {
        val fortyAdapter =
            SlideHadithAdapter(
                context,
                Hadiths
            )
        binding.viewpager.adapter = fortyAdapter
    }

}