package com.almasabdykadyr.currency.domain.mappers

import java.io.Serializable
import java.math.BigDecimal

/**
 * DTO for { @link com.almasabdykadyr.currency.domain.entities.ExchangeRate }
 */
data class ExchangeRateDto(
    val id: Int? = null,
    val baseCurrency: CurrencyDto? = null,
    val targetCurrency: CurrencyDto? = null,
    val rate: BigDecimal? = null
) : Serializable