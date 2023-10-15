package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.dto.ExchangeRateAddingDTO
import com.almasabdykadyr.currency.dto.ExchangeRateDTO
import com.almasabdykadyr.currency.entities.ExchangeRate
import com.almasabdykadyr.currency.services.ExchangeRatesService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ExchangeRateController(private val service: ExchangeRatesService) {

    @GetMapping("/exchangeRates")
    fun getAll(): ResponseEntity<List<ExchangeRateDTO>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

    @GetMapping("/exchangeRates/{currencyPair}")
    fun getByCodes(@PathVariable currencyPair: String): ResponseEntity<ExchangeRateDTO> {
        return ResponseEntity(service.getByCurrencyPair(parseCurrencyCodes(currencyPair).first, parseCurrencyCodes(currencyPair).second), HttpStatus.OK)
    }

    @PostMapping("/exchangeRates")
    fun addExchangeRate(@RequestBody exchangeRate: ExchangeRateAddingDTO) {
        return service.insert()
    }

    private companion object {
        fun parseCurrencyCodes(currencyPair: String): Pair<String, String> {
            val baseCurrencyCode = currencyPair.substring(0, 3).uppercase()
            val targetCurrencyCode = currencyPair.substring(3, 6).uppercase()

            return baseCurrencyCode to targetCurrencyCode
        }
    }

}