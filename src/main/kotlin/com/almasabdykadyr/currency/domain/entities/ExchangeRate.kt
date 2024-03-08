package com.almasabdykadyr.currency.domain.entities

import com.almasabdykadyr.currency.domain.entities.BaseEntity
import com.almasabdykadyr.currency.domain.entities.Currency
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "exchange_rates")
class ExchangeRate(

    @ManyToOne(targetEntity = Currency::class, fetch = FetchType.LAZY)
    @JoinColumn( name = "base_currency", referencedColumnName = "id" )
    var baseCurrency: Currency,

    @ManyToOne(targetEntity = Currency::class, fetch = FetchType.LAZY)
    @JoinColumn( name = "target_currency", referencedColumnName = "id" )
    var targetCurrency: Currency,

    @Column(name = "rate") var rate: BigDecimal
) : BaseEntity<Int>()