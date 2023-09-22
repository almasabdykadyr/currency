package com.almasabdykadyr.currency.entities.mappers

import com.almasabdykadyr.currency.dto.CurrencyDTO
import com.almasabdykadyr.currency.entities.Currency

interface CurrencyEntityToDtoMapper {

    fun toEntity(currencyDTO: CurrencyDTO): Currency

    fun toDto(currency: Currency): CurrencyDTO

}