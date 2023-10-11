package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.dto.ExchangeRateDTO

interface ExchangeRatesService {

    fun getAll(): List<ExchangeRateDTO>
    fun getByCurrencyPair(baseCurrencyCode: String, targetCurrencyCode: String): ExchangeRateDTO

}