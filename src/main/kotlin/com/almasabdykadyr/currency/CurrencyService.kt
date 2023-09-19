package com.almasabdykadyr.currency

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class CurrencyService(@Autowired private val repository: CurrencyRepository) {

    fun getAll(): List<Currency> = repository.findAll().toList()

    fun getByCode(code: String): Currency {

        if (code.isEmpty()) {
            throw IllegalArgumentException("Currency code should not be empty")
        } else {
            try {
                repository.findByCode(code)
            } catch (noDataEx: EmptyResultDataAccessException) {
                throw EmptyResultDataAccessException("No currency with this code", 1)
            }
        }

        return repository.findByCode(code)
    }

}