package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.domain.entities.Currency
import com.almasabdykadyr.currency.domain.mappers.CurrencyDto
import com.almasabdykadyr.currency.services.CurrencyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.math.log

@RestController
@RequestMapping("/api")
class CurrencyController(private val service: CurrencyService) {

    @RequestMapping("/is-alive")
    fun isAlive(): String = "Servers is alive"

    @GetMapping("/currencies")
    fun getAll(): ResponseEntity<List<CurrencyDto>> {
        return ResponseEntity.ok(service.getAll())
    }

    @GetMapping("/currency/{code}")
    fun getByCode(@PathVariable code: String): ResponseEntity<CurrencyDto> {
        return ResponseEntity.ofNullable(service.getByCode(code))
    }

    @PostMapping("/currencies")
    fun addCurrency(@RequestBody currency: CurrencyDto): ResponseEntity<CurrencyDto>{
        return ResponseEntity.ok(service.insert(currency))
    }
}
