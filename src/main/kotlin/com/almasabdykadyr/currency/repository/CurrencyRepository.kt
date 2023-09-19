package com.almasabdykadyr.currency.repository

import com.almasabdykadyr.currency.entities.Currency
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CurrencyRepository : CrudRepository<Currency, Long> {

    fun findByCode(code: String): Optional<Currency>

}