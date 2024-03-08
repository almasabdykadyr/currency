package com.almasabdykadyr.currency.services

import com.almasabdykadyr.currency.domain.entities.User

interface UserService {

    fun getByEmail(email: String): User?
    fun insert(user: User): User
}