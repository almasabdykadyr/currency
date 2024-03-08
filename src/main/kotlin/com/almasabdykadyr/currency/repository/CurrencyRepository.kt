package com.almasabdykadyr.currency.repository

import com.almasabdykadyr.currency.domain.entities.Currency
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CurrencyRepository : CrudRepository<Currency, Int> {

    fun findByCode(code: String): Optional<Currency>
}