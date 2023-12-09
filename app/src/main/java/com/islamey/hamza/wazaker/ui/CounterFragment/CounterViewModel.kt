package com.islamey.hamza.wazaker.ui.CounterFragment

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {

    private val _counts = MutableStateFlow(0)
    val counts: StateFlow<Int> get() = _counts

    private val _totalCounts = MutableStateFlow(0)
    val totalCounts: StateFlow<Int> get() = _totalCounts

    init {
        viewModelScope.launch {
            _totalCounts.value = getTotalCountsFromSharedPreference()
        }
    }

    fun incrementCounter() {
        _counts.value++
        _totalCounts.value++
        saveTotalCountsInSharedPreference()
    }

    fun resetCounter() {
        _counts.value = 0
    }

    fun resetTotalCounter() {
        _totalCounts.value = 0
        saveTotalCountsInSharedPreference()
    }

    private fun saveTotalCountsInSharedPreference() {
        val sharedPref = getSharedPreferences()
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt("totalCounts", _totalCounts.value)
        editor.apply()
    }

    private fun getTotalCountsFromSharedPreference(): Int {
        val sharedPref = getSharedPreferences()
        return sharedPref.getInt("totalCounts", 0)
    }

    private fun getSharedPreferences(): SharedPreferences {
        return application.getSharedPreferences(
            "pref", Context.MODE_PRIVATE
        )
    }


}