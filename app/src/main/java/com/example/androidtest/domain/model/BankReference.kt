package com.example.androidtest.domain.model

data class ImageUrl(
    val url3X3: String? = null,
    val url4X4: String? = null,
    val url5X5: String? = null,
    val url6X6: String? = null,
    val url7X7: String? = null
)

data class BankReference(
    val bank: String,
    val reference: String,
    val aliasbank: String,
    val images: List<ImageUrl> = emptyList()
)