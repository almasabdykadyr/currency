package com.almasabdykadyr.currency.repository

import com.almasabdykadyr.currency.domain.entities.ExchangeRate
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ExchangesRatesRepository : CrudRepository<ExchangeRate, Int> {
    @Query("SELECT er FROM ExchangeRate er WHERE er.baseCurrency.code = :baseCurrencyCode AND er.targetCurrency.code = :targetCurrencyCode")
    fun findByCodes(baseCurrencyCode: String, targetCurrencyCode: String): Optional<ExchangeRate>
}