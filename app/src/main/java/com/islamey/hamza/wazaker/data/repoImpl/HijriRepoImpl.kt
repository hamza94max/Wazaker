package com.islamey.hamza.wazaker.data.repoImpl

import com.islamey.hamza.wazaker.data.remote.ApiService
import com.islamey.hamza.wazaker.domain.Models.HijriDateResponse
import com.islamey.hamza.wazaker.domain.repo.HijriRepo

class HijriRepoImpl(private val apiService: ApiService) : HijriRepo {


    override suspend fun getHijriDate(date: String): HijriDateResponse {
        return apiService.getHijriDate(date)
    }


}