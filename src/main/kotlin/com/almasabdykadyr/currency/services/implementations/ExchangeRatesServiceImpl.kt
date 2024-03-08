package com.almasabdykadyr.currency.services.implementations

import com.almasabdykadyr.currency.domain.entities.ExchangeRate
import com.almasabdykadyr.currency.domain.mappers.ExchangeRateDto
import com.almasabdykadyr.currency.domain.mappers.ExchangeRateMapper
import com.almasabdykadyr.currency.repository.CurrencyRepository
import com.almasabdykadyr.currency.repository.ExchangesRatesRepository
import com.almasabdykadyr.currency.services.ExchangeRatesService
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ExchangeRatesServiceImpl(
    private val exchangesRatesRepository: ExchangesRatesRepository,
    private val currencyRepository: CurrencyRepository,
    private val exchangeRateMapper: ExchangeRateMapper
) : ExchangeRatesService {

    override fun getAll(): List<ExchangeRateDto> {
        return exchangesRatesRepository.findAll().map(exchangeRateMapper::toDto)
    }

    override fun insert(exchangeRateDto: ExchangeRateDto): ExchangeRateDto {
        return exchangeRateDto.apply {
            exchangesRatesRepository.save(exchangeRateMapper.toEntity(this))
        }
    }

    override fun getByCurrencyPair(codesPath: String): ExchangeRateDto? {

        val baseCurrencyCode: String = parseCodes(codesPath).first
        val targetCurrencyCode: String = parseCodes(codesPath).second

        return exchangesRatesRepository.findByCodes(
            baseCurrencyCode = baseCurrencyCode,
            targetCurrencyCode = targetCurrencyCode
        ).map(exchangeRateMapper::toDto).getOrNull()
    }

    private fun parseCodes(path: String): Pair<String, String> {
        val first: String = path.substring(0, 3)
        val second: String = path.substring(3, 6)


        return Pair(first, second)
    }

}