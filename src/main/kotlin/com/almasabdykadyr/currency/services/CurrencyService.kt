package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.domain.mappers.CurrencyDto

interface CurrencyService {

    fun getAll(): List<CurrencyDto>
    fun getById(id: Int): CurrencyDto?
    fun getByCode(code: String): CurrencyDto?
    fun insert(currencyDto: CurrencyDto): CurrencyDto
}