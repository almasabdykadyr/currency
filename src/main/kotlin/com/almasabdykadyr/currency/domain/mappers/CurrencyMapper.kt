package com.almasabdykadyr.currency.domain.mappers

import com.almasabdykadyr.currency.domain.entities.Currency
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
interface CurrencyMapper {

    fun toEntity(currencyDto: CurrencyDto): Currency

    fun toDto(currency: Currency): CurrencyDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun partialUpdate(currencyDto: CurrencyDto, @MappingTarget currency: Currency): Currency
}