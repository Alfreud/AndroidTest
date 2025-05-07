package com.example.androidtest.data.remote.dto

data class ImageUrlDto(
    val url3X3: String? = null,
    val url4X4: String? = null,
    val url5X5: String? = null,
    val url6X6: String? = null,
    val url7X7: String? = null
)

data class BankReferenceDto(
    val bank: String,
    val reference: String,
    val aliasbank: String,
    val images: List<ImageUrlDto> = emptyList()
)

data class ListResponseDto(val status: Int, val arrayReferences: List<BankReferenceDto>)