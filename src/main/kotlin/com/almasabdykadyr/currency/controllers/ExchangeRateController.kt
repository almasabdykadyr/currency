package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.dto.ExchangeRateDTO
import com.almasabdykadyr.currency.services.ExchangeRatesService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ExchangeRateController(private val service: ExchangeRatesService) {

    @GetMapping("/exchangeRates")
    fun getAll(): ResponseEntity<List<ExchangeRateDTO>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

    @GetMapping("/exchangeRates/{currencyPair}")
    fun getByCodes(@PathVariable currencyPair: String): ResponseEntity<ExchangeRateDTO> {
        val baseCurrencyCode = currencyPair.substring(0, 3).uppercase()
        val targetCurrencyCode = currencyPair.substring(3, 6).uppercase()
        return ResponseEntity(service.getByCurrencyPair(baseCurrencyCode, targetCurrencyCode), HttpStatus.OK)
    }
}