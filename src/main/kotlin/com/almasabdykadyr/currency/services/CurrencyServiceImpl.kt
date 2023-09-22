package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.dto.CurrencyDTO
import com.almasabdykadyr.currency.entities.Currency
import com.almasabdykadyr.currency.entities.mappers.CurrencyEntityToDtoMapper
import com.almasabdykadyr.currency.repository.CurrencyRepository
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service

//FIXME: *IMPORTANT* write mapper, to use DTO for requests

@Service
class CurrencyServiceImpl(private val repository: CurrencyRepository, private val mapper: CurrencyEntityToDtoMapper) :
    CurrencyService {

    override fun getAll(): List<CurrencyDTO> {
        return try {
            repository.findAll().map {
                mapper.toDto(it)
            }.toList()
        } catch (e: Exception) {
            throw object : DataAccessException("Error to access to datasource", e) {}
        }
    }

    override fun getById(id: Long): CurrencyDTO {
        return mapper.toDto(repository.findById(id).get())
    }

    override fun getByCode(code: String): CurrencyDTO {
        return mapper.toDto(repository.findByCode(code).get())
    }

    override fun insert(code: String, fullName: String, sign: String): CurrencyDTO {
    return mapper.toDto(repository.save(Currency(code = code, fullName = fullName, sign = sign)))
    }

}