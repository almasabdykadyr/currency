package com.almasabdykadyr.currency.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "currencies")
open class Currency(

    @Id
    @GeneratedValue
    open val id: Long? = null,

    @Column(name = "code") open val code: String? = null,

    @Column(name = "full_name") open val fullName: String? = null,

    @Column(name = "sign") open val sign: String? = null

)