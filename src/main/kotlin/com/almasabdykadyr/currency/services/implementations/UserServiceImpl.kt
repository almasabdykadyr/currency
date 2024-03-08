package com.almasabdykadyr.currency.services.implementations

import com.almasabdykadyr.currency.domain.entities.User
import com.almasabdykadyr.currency.repository.UserRepository
import com.almasabdykadyr.currency.services.UserService
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService {

    override fun getByEmail(email: String): User? {
        return userRepository.findByEmail(email).getOrNull()
    }

    override fun insert(user: User): User {
        return userRepository.save(user)
    }
}