package com.almasabdykadyr.currency.entities.mappers

import com.almasabdykadyr.currency.dto.CurrencyDTO
import com.almasabdykadyr.currency.entities.Currency
import org.springframework.stereotype.Component

@Component
class CurrencyMapperImpl: CurrencyMapper {

    override fun toEntity(currencyDTO: CurrencyDTO): Currency {
        return Currency(
            id = currencyDTO.id,
            code = currencyDTO.code,
            fullName = currencyDTO.fullName,
            sign = currencyDTO.sign
        )
    }

    override fun toDto(currency: Currency): CurrencyDTO {
        return CurrencyDTO(
            id = currency.id!!,
            code = currency.code!!,
            fullName = currency.fullName!!,
            sign = currency.sign!!
        )
    }
}