package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.domain.mappers.ExchangeRateDto
import java.math.BigDecimal

interface ExchangeRatesService {

    fun getAll(): List<ExchangeRateDto>
    fun getByCurrencyPair(codesPath: String): ExchangeRateDto?
    fun insert(exchangeRateDto: ExchangeRateDto): ExchangeRateDto
}