package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.dto.CurrencyAddingDTO
import com.almasabdykadyr.currency.dto.CurrencyDTO
import com.almasabdykadyr.currency.services.CurrencyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CurrencyController(private val service: CurrencyService) {

    @RequestMapping("/is-alive")
    fun isAlive(): String = "Servers is alive"

    @GetMapping("/currencies")
    fun getAll(): ResponseEntity<List<CurrencyDTO>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

    @GetMapping("/currency/{code}")
    fun getByCode(@PathVariable code: String): ResponseEntity<CurrencyDTO> {
        return try {
            ResponseEntity(service.getByCode(code), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/currency")
    fun addCurrency(@RequestBody currency: CurrencyAddingDTO): CurrencyDTO {
        return service.insert(currency.code, currency.name, currency.sign)
    }
}
