package com.almasabdykadyr.currency.domain.mappers

import java.io.Serializable

data class LoginDto(
    var email: String? = null,
    var password: String? = null
) :
    Serializable