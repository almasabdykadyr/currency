package com.almasabdykadyr.currency.entities

import jakarta.persistence.*

@Entity
@Table(name = "currencies")
open class Currency(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long? = null,

    @Column(name = "code") open val code: String? = null,

    @Column(name = "full_name") open val fullName: String? = null,

    @Column(name = "sign") open val sign: String? = null

)