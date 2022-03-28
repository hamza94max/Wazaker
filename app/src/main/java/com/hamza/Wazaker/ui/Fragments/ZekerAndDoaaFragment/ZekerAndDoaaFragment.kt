package com.hamza.Wazaker.ui.Fragments.ZekerAndDoaaFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.hamza.Wazaker.Data.DataSets.ZekerDataSet
import com.hamza.Wazaker.Data.Models.ZekerModel
import com.hamza.wazkar.databinding.FragmentZekerAndDoaaBinding


class ZekerAndDoaaFragment : Fragment() {

    var _binding: FragmentZekerAndDoaaBinding? = null
    val binding get() = _binding!!

    private var zekerItems: List<ZekerModel>? = null
    var zekerCounts: IntArray? = null

    private val args: ZekerAndDoaaFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentZekerAndDoaaBinding.inflate(layoutInflater, container, false)

        binding.viewpager.addOnPageChangeListener(object : OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
                val s = java.lang.String.valueOf(zekerCounts!![binding.viewpager.currentItem])
                binding.textViewplus.text = s
                binding.plusbtn.setOnClickListener {
                    updateScreen()
                    autoswap(binding.viewpager, binding.viewpager.currentItem)
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }

        })

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData(args.zekerintent)

        val azkardapter =
            SlideAzkarAdapter(
                context,
                zekerItems
            )
        binding.viewpager.adapter = azkardapter


        binding.plusbtn.setOnClickListener {
            updateScreen()
            autoswap(binding.viewpager, binding.viewpager.currentItem)
        }

        binding.copybtn.setOnClickListener {
            shareZeker()
        }

    }

    private fun loadData(index: Int) {
        zekerItems = ZekerDataSet.getZekerList(index)
        zekerCounts = IntArray((zekerItems as MutableList<ZekerModel>?)!!.size)
    }

    private fun updateScreen() {
        zekerCounts!![binding.viewpager.currentItem]++
        val s = java.lang.String.valueOf(zekerCounts!![binding.viewpager.currentItem])
        binding.textViewplus.text = s
    }

    fun autoswap(viewPager: ViewPager, index: Int) {
        val currentcounts = zekerCounts!![binding.viewpager.currentItem]
        val Zekercounts: Int = zekerItems!![index].counter
        if (currentcounts == Zekercounts) {
            val next_page = viewPager.currentItem + 1
            viewPager.setCurrentItem(next_page, true)
        }
    }

    fun shareZeker() {
        val zeker: String = zekerItems!![binding.viewpager.currentItem].zeker
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, zeker)
        sendIntent.type = "text/plain"
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}