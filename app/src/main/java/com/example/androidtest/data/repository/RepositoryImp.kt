package com.example.androidtest.data.repository

import com.example.androidtest.data.modelmapper.toDomain
import com.example.androidtest.data.remote.api.ApiService
import com.example.androidtest.data.remote.dto.LoginRequestDto
import com.example.androidtest.domain.model.BankReference
import com.example.androidtest.domain.repository.Repository

class RepositoryImpl(private val api: ApiService) : Repository {
    override suspend fun login(user: String, pass: String): String {
        val response = api.login(LoginRequestDto(user, pass))
        return response.session
    }

    override suspend fun getReferences(session: String): List<BankReference> {
        val response = api.getList(mapOf("session" to session))
        return response.arrayReferences.map { it.toDomain() }
    }
}