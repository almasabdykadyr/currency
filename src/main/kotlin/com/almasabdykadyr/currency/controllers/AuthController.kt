package com.almasabdykadyr.currency.controllers

import com.almasabdykadyr.currency.domain.entities.User
import com.almasabdykadyr.currency.domain.mappers.LoginDto
import com.almasabdykadyr.currency.domain.mappers.LoginResponseDto
import com.almasabdykadyr.currency.domain.mappers.RegisterDto
import com.almasabdykadyr.currency.security.ApiException
import com.almasabdykadyr.currency.security.HashService
import com.almasabdykadyr.currency.security.TokenService
import com.almasabdykadyr.currency.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val hashService: HashService,
    private val tokenService: TokenService,
    private val userService: UserService,
) {
    @PostMapping("/login")
    fun login(@RequestBody payload: LoginDto): ResponseEntity<LoginResponseDto> {
        val user = userService.getByEmail(payload.email!!) ?: throw ApiException(400, "Login failed")

        if (!hashService.checkBcrypt(payload.password!!, user.pwd)) {
            throw ApiException(400, "Login failed")
        }

        return ResponseEntity.ok().header("Location", "/index.html").body(LoginResponseDto(
            token = tokenService.createToken(user),
        ))
    }

    @PostMapping("/register")
    fun register(@RequestBody payload: RegisterDto): LoginResponseDto {
        val user = User(
            email = payload.email!!,
            pwd = hashService.hashBcrypt(payload.password!!),
        )

        val savedUser = userService.insert(user)

        return LoginResponseDto(
            token = tokenService.createToken(savedUser),
        )
    }
}