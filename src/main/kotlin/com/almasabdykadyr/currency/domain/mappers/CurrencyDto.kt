package com.almasabdykadyr.currency.domain.mappers

import java.io.Serializable

/**
 * DTO for {@link com.almasabdykadyr.currency.domain.entities.Currency}
 */
data class CurrencyDto(
    var id: Int? = null,
    var name: String? = null,
    var code: String? = null,
    var sign: String? = null
) :
    Serializable