package com.example.androidtest.domain.usecase

import com.example.androidtest.domain.model.BankReference
import com.example.androidtest.domain.repository.Repository

class GetReferencesUseCase(private val repo: Repository) {
    suspend operator fun invoke(session: String): List<BankReference> = repo.getReferences(session)
}