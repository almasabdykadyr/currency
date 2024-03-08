package com.almasabdykadyr.currency.services.implementations

import com.almasabdykadyr.currency.domain.mappers.CurrencyDto
import com.almasabdykadyr.currency.domain.mappers.CurrencyMapper
import com.almasabdykadyr.currency.repository.CurrencyRepository
import com.almasabdykadyr.currency.services.CurrencyService
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class CurrencyServiceImpl(private val repository: CurrencyRepository, private val currencyMapper: CurrencyMapper) :
    CurrencyService {

    override fun getAll(): List<CurrencyDto> {
        return repository.findAll().map(currencyMapper::toDto)
    }

    override fun getById(id: Int): CurrencyDto? {
        return repository.findById(id).map(currencyMapper::toDto).getOrNull()
    }

    override fun getByCode(code: String): CurrencyDto? {
        return repository.findByCode(code).map(currencyMapper::toDto).getOrNull()
    }

    override fun insert(currencyDto: CurrencyDto): CurrencyDto {
        //TODO: make more readable
        return currencyMapper.toDto(repository.save(currencyMapper.toEntity(currencyDto)))
    }
}