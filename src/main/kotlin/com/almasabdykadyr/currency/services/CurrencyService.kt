package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.entities.Currency

interface CurrencyService {

    fun getAll(): List<Currency?>
    fun getById(id: Long): Currency?
    fun getByCode(code: String): Currency?
    fun insert(code: String, fullName: String, sign: String): Currency

}