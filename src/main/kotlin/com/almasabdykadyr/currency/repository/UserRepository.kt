package com.almasabdykadyr.currency.repository

import com.almasabdykadyr.currency.domain.entities.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, UUID> {

    fun findByEmail(email: String): Optional<User>
}