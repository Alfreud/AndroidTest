package com.example.androidtest.domain.repository

import com.example.androidtest.domain.model.BankReference

interface Repository {
    suspend fun login(user: String, pass: String): String
    suspend fun getReferences(session: String): List<BankReference>
}