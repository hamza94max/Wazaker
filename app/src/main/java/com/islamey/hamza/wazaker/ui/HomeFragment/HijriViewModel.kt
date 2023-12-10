package com.islamey.hamza.wazaker.ui.HomeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islamey.hamza.wazaker.domain.Models.HijriDateResponse
import com.islamey.hamza.wazaker.domain.repo.HijriRepo
import com.islamey.hamza.wazaker.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HijriViewModel @Inject constructor(
    private val hijriRepo: HijriRepo
) : ViewModel() {

    private val _hijriDate = MutableStateFlow<DataState<HijriDateResponse>>(DataState.Idle)
    val hijriDate: StateFlow<DataState<HijriDateResponse>> = _hijriDate

    fun getHijriDate(date: String) {
        viewModelScope.launch {
            _hijriDate.value = DataState.Loading

            try {
                val result = hijriRepo.getHijriDate(date)
                _hijriDate.value = DataState.Success(result)
            } catch (e: Exception) {
                _hijriDate.value = DataState.Error(e.message ?: "An error occurred")
            }
        }
    }
}
