package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.domain.mappers.ExchangeRateDto
import com.almasabdykadyr.currency.services.ExchangeRatesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ExchangeRateController(private val service: ExchangeRatesService) {

    @GetMapping("/exchangeRates")
    fun getAll(): ResponseEntity<List<ExchangeRateDto>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

    @GetMapping("/exchangeRates/{currencyPair}")
    fun getByCodes(@PathVariable currencyPair: String): ResponseEntity<ExchangeRateDto> {
        return ResponseEntity.ofNullable(service.getByCurrencyPair(currencyPair))
    }

    @PostMapping("/exchangeRates")
    fun addExchangeRate(@RequestBody exchangeRate: ExchangeRateDto): ResponseEntity<ExchangeRateDto>{
        return ResponseEntity.ofNullable(service.insert(exchangeRate))
    }
}