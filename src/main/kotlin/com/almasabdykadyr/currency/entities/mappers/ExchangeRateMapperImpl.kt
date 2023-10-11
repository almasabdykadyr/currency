package com.almasabdykadyr.currency.entities.mappers

import com.almasabdykadyr.currency.dto.CurrencyDTO
import com.almasabdykadyr.currency.dto.ExchangeRateDTO
import com.almasabdykadyr.currency.entities.Currency
import com.almasabdykadyr.currency.entities.ExchangeRate
import org.springframework.stereotype.Component

//FIXME(refactor)

@Component
class ExchangeRateMapperImpl: ExchangeRateMapper {

    override fun toEntity(item: ExchangeRateDTO): ExchangeRate {
        return ExchangeRate(
            id = item.id,
            baseCurrency = Currency(item.baseCurrency.id, item.baseCurrency.code, item.baseCurrency.fullName, item.baseCurrency.sign),
            targetCurrency = Currency(item.targetCurrency.id, item.targetCurrency.code, item.targetCurrency.fullName, item.targetCurrency.sign),
            rate = item.rate
        )
    }

    override fun toDto(item: ExchangeRate): ExchangeRateDTO {
        return ExchangeRateDTO(
            id = item.id!!,
            baseCurrency = CurrencyDTO(item.baseCurrency!!.id!!, item.baseCurrency!!.code!!, item.baseCurrency!!.fullName!!, item.baseCurrency!!.sign!!),
            targetCurrency = CurrencyDTO(item.targetCurrency!!.id!!, item.targetCurrency!!.code!!, item.targetCurrency!!.fullName!!, item.targetCurrency!!.sign!!),
            rate = item.rate!!
        )
    }
}