package com.almasabdykadyr.currency.domain.mappers

import com.almasabdykadyr.currency.domain.entities.ExchangeRate
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class ExchangeRateMapper {

    abstract fun toEntity(exchangeRateDto: ExchangeRateDto): ExchangeRate

    abstract fun toDto(exchangeRate: ExchangeRate): ExchangeRateDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(
        exchangeRateDto: ExchangeRateDto,
        @MappingTarget exchangeRate: ExchangeRate
    ): ExchangeRate
}