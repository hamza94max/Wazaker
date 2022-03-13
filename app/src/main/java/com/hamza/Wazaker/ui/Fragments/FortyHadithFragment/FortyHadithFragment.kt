package com.hamza.Wazaker.ui.Fragments.FortyHadithFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.Wazaker.Data.DataSets.FortyDataSet
import com.hamza.Wazaker.Data.Models.Hadith
import com.hamza.wazkar.databinding.FragmentFortyHadithBinding

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


    //    private fun shareHadith() {
//        val item = Hadiths[binding.viewpager.currentItem]
//
//        val sendIntent = Intent()
//        sendIntent.action = Intent.ACTION_SEND
//        sendIntent.putExtra(Intent.EXTRA_TEXT, item)
//        sendIntent.type = "text/plain"
//
//        val shareIntent = Intent.createChooser(sendIntent, null)
//        startActivity(shareIntent)
//    }

}