package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.dto.ExchangeRateDTO
import com.almasabdykadyr.currency.services.ExchangeRatesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExchangeRateController(private val service: ExchangeRatesService) {

    @GetMapping("/exchangeRates")
    fun getAll(): ResponseEntity<List<ExchangeRateDTO>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

}