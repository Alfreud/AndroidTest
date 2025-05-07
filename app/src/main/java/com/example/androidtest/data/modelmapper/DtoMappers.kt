package com.example.androidtest.data.modelmapper

import com.example.androidtest.data.remote.dto.BankReferenceDto
import com.example.androidtest.data.remote.dto.ImageUrlDto
import com.example.androidtest.domain.model.BankReference
import com.example.androidtest.domain.model.ImageUrl

fun BankReferenceDto.toDomain(): BankReference {
    return BankReference(
        bank = bank,
        reference = reference,
        aliasbank = aliasbank,
        images = images.map { it.toDomain() }
    )
}

fun ImageUrlDto.toDomain(): ImageUrl {
    return ImageUrl(url3X3, url4X4, url5X5, url6X6, url7X7)
}