package com.almasabdykadyr.currency

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class CurrencyApplication

fun main(args: Array<String>) {
    runApplication<CurrencyApplication>(*args)
}
