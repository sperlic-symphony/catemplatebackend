package com.symphony.catemplate.catemplate.controller

import com.symphony.catemplate.catemplate.controller.dependency.PollutionRepository
import com.symphony.catemplate.catemplate.controller.model.PollutionDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PollutionController {

    @Autowired
    lateinit var pollutionRepository: PollutionRepository

    @GetMapping("/pollution")
    suspend fun pollution(
        @RequestParam("lat") lat: String,
        @RequestParam("lon") lng: String
    ): ResponseEntity<PollutionDto> {
        return ResponseEntity(pollutionRepository.getPollution(lat.toDouble(), lng.toDouble()).convertToDto(), HttpStatus.OK)
    }
}