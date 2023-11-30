package com.islamey.hamza.wazaker.data.remote

import com.islamey.hamza.wazaker.domain.Models.HijriDateResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("v1/gToH/{date}")
    suspend fun getHijriDate(
        @Path("date") date: String
    ): HijriDateResponse

}