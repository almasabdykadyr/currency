package com.almasabdykadyr.currency.dto

import java.math.BigDecimal

data class ExchangeRateDTO(
    val id: Long, val baseCurrency: CurrencyDTO, val targetCurrency: CurrencyDTO, val rate: BigDecimal
)