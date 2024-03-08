package com.almasabdykadyr.currency.domain.entities

import com.almasabdykadyr.currency.domain.entities.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "currencies")
class Currency(

    @Column(name = "name") var name: String,
    @Column(name = "code", length = 3) var code: String,
    @Column(name = "sign", length = 1) var sign: String,
) : BaseEntity<Int>()