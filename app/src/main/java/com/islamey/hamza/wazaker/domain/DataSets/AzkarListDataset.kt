package com.islamey.hamza.wazaker.domain.DataSets

import android.content.Context
import com.islamey.hamza.wazaker.domain.Models.AzkarListModel
import com.islamey.wazkar.R

object AzkarListDataset {
    private lateinit var azkarList: MutableList<AzkarListModel>

    fun getAzkarList(context: Context): List<AzkarListModel> {
        azkarList = ArrayList()
        azkarList.add(AzkarListModel(context.getString(R.string.majed_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.after_salah_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.azan_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.wodoa_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.qurany_doaa)))
        azkarList.add(AzkarListModel(context.getString(R.string.naboya_doaa)))
        azkarList.add(AzkarListModel(context.getString(R.string.food_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.house_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.sleep_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.wakeup_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.great_azkar)))
        azkarList.add(AzkarListModel(context.getString(R.string.traveling_doaa)))
        azkarList.add(AzkarListModel(context.getString(R.string.quran_completed_doaa)))
        azkarList.add(AzkarListModel(context.getString(R.string.doaa_fdel)))
        azkarList.add(AzkarListModel(context.getString(R.string.quran_reading_fadl)))
        azkarList.add(AzkarListModel(context.getString(R.string.azkar_fadl)))
        azkarList.add(AzkarListModel(context.getString(R.string.roqia)))
        azkarList.add(AzkarListModel(context.getString(R.string.dead_doaa)))

        return azkarList
    }
}