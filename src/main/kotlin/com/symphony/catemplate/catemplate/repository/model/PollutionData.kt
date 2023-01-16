package com.symphony.catemplate.catemplate.repository.model

import com.symphony.catemplate.catemplate.controller.model.PollutionDto

data class PollutionData(val data: Data)
data class Data(val current: Current)
data class Current(val pollution: Pollution)

class Pollution(
    val aqius: Int,
    val mainus: String,
) {
    fun convertToDto(): PollutionDto {
        return PollutionDto(aqius, mainus, "ugm/3")
    }
}
