package com.almasabdykadyr.currency.services.implementations

import com.almasabdykadyr.currency.dto.ExchangeRateDTO
import com.almasabdykadyr.currency.entities.mappers.ExchangeRateMapper
import com.almasabdykadyr.currency.repository.ExchangesRatesRepository
import com.almasabdykadyr.currency.services.ExchangeRatesService
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service

@Service
class ExchangeRatesServiceImpl(private val repository: ExchangesRatesRepository, private val mapper: ExchangeRateMapper): ExchangeRatesService {

    override fun getAll(): List<ExchangeRateDTO> {
        return try {
            repository.findAll().map {
                mapper.toDto(it)
            }
        } catch (e: Exception) {
            throw object: DataAccessException("Error to access to datasource", e) {}
        }
    }

    override fun getByCurrencyPair(baseCurrencyCode: String, targetCurrencyCode: String): ExchangeRateDTO {
        return try {
            repository.findByCodes(baseCurrencyCode, targetCurrencyCode).let {
                mapper.toDto(it)
            }
        } catch (e: Exception) {
            throw object: DataAccessException("Error to access to datasource", e) {}
        }
    }
}