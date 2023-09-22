package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.dto.CurrencyDTO
import com.almasabdykadyr.currency.entities.Currency

interface CurrencyService {

    fun getAll(): List<CurrencyDTO>
    fun getById(id: Long): CurrencyDTO
    fun getByCode(code: String): CurrencyDTO
    fun insert(code: String, fullName: String, sign: String): CurrencyDTO

}