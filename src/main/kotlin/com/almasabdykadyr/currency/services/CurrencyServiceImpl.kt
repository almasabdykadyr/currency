package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.entities.Currency
import com.almasabdykadyr.currency.repository.CurrencyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class CurrencyServiceImpl(@Autowired private val repository: CurrencyRepository) : CurrencyService {

    override fun getAll(): List<Currency?> {
        return repository.findAll().toList()
    }

    override fun getById(id: Long): Currency? {
        return repository.findById(id).getOrNull()
    }

    override fun getByCode(code: String): Currency? {
        return repository.findByCode(code).getOrNull()
    }

    override fun insert(code: String, fullName: String, sign: String): Currency {
        return repository.save(Currency(code= code, fullName =  fullName, sign =  sign))
    }
}