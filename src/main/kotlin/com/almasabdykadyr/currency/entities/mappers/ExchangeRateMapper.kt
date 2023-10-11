package com.almasabdykadyr.currency.entities.mappers

import com.almasabdykadyr.currency.dto.ExchangeRateDTO
import com.almasabdykadyr.currency.entities.ExchangeRate

interface ExchangeRateMapper {
    fun toEntity(item: ExchangeRateDTO): ExchangeRate
    fun toDto(item: ExchangeRate): ExchangeRateDTO
}