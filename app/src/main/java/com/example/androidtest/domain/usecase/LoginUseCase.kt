package com.example.androidtest.domain.usecase

import com.example.androidtest.domain.repository.Repository

class LoginUseCase(private val repo: Repository) {
    suspend operator fun invoke(user: String, pass: String): String = repo.login(user, pass)
}