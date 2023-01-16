package com.symphony.catemplate.catemplate.controller.dependency

import com.symphony.catemplate.catemplate.repository.model.Pollution

interface PollutionRepository {
    suspend fun getPollution(lat: Double, lon: Double): Pollution
}