package com.islamey.hamza.wazaker.domain.repo

import com.islamey.hamza.wazaker.domain.Models.HijriDateResponse

interface HijriRepo {


    suspend fun getHijriDate(date: String): HijriDateResponse


}