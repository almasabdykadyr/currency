package com.almasabdykadyr.currency.dto

import java.math.BigDecimal

data class ExchangeRateAddingDTO (val baseCurrencyCode: String, val targetCurrency: String, val rate: BigDecimal)