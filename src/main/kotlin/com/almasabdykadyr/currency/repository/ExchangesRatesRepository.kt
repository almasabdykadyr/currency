package com.almasabdykadyr.currency.repository

import com.almasabdykadyr.currency.entities.ExchangeRate
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExchangesRatesRepository : CrudRepository<ExchangeRate, Long> {
    @Query("SELECT er.id FROM ExchangeRate er")
    fun findByCodes(baseCurrencyCode: String, targetCurrencyCode: String): ExchangeRate
}