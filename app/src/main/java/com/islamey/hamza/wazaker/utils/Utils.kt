package com.islamey.hamza.wazaker.utils

import android.content.Context

object Utils {


    fun getTotalCounts(context: Context): Int {
        val sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

        return sharedPreferences.getInt("totalCounts", 0)
    }


    fun saveTotalCountsInSharedPreference(context: Context, totalCounts: Int) {
        val sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putInt("totalCounts", totalCounts)
        editor.apply()
    }


}