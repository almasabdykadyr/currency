package com.almasabdykadyr.currency.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "exchange_rates")
open class ExchangeRate(
    @Id
    @GeneratedValue
    open val id: Long? = null,

    @ManyToOne
    @JoinColumn(name="base_currency_id", referencedColumnName = "id")
    open val baseCurrency: Currency? = null,

    @ManyToOne
    @JoinColumn(name="target_currency_id", referencedColumnName = "id")
    open val targetCurrency: Currency? = null,

    @Column open val rate: BigDecimal? = null
)