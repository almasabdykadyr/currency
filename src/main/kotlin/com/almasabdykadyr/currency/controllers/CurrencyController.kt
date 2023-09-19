package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.entities.Currency
import com.almasabdykadyr.currency.services.CurrencyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CurrencyController(@Autowired private val service: CurrencyService) {

    @RequestMapping("/is-alive")
    fun isAlive(): String = "Servers is alive"

    @GetMapping("/currencies")
    fun getAll(): ResponseEntity<List<Currency?>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

    @GetMapping("/currency/{code}")
    fun getByCode(@PathVariable code: String): ResponseEntity<Currency> {
        return ResponseEntity(service.getByCode(code), HttpStatus.OK)
    }
}
