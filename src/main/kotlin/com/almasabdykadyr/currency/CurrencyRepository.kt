package com.almasabdykadyr.currency

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CurrencyRepository : CrudRepository<Currency, Long> {

    fun findByCode(code: String): Currency

}