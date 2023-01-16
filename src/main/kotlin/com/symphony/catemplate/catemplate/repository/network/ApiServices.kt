package com.symphony.catemplate.catemplate.repository.network

import com.symphony.catemplate.catemplate.repository.model.Pollution
import com.symphony.catemplate.catemplate.repository.model.PollutionData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("nearest_city")
    suspend fun getPollution(@Query("lat") lat: Double, @Query("lon") lng: Double): Response<PollutionData>
}