package com.symphony.catemplate.catemplate.repository

import com.symphony.catemplate.catemplate.controller.dependency.PollutionRepository
import com.symphony.catemplate.catemplate.repository.model.Pollution
import com.symphony.catemplate.catemplate.repository.network.HttpClientImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PollutionRepositoryImpl : PollutionRepository {

    @Autowired
    lateinit var httpClientImpl: HttpClientImpl

    override suspend fun getPollution(lat: Double, lon: Double): Pollution {
        return httpClientImpl.getPollution(lat, lon)
    }
}