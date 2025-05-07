package com.example.androidtest.di

import com.example.androidtest.data.remote.api.ApiService
import com.example.androidtest.data.remote.dto.BankReferenceDto
import com.example.androidtest.data.remote.dto.ImageUrlDto
import com.example.androidtest.data.remote.dto.ListResponseDto
import com.example.androidtest.data.remote.dto.LoginRequestDto
import com.example.androidtest.data.remote.dto.LoginResponseDto
import com.example.androidtest.data.repository.RepositoryImpl
import com.example.androidtest.domain.repository.Repository
import com.example.androidtest.domain.usecase.GetReferencesUseCase
import com.example.androidtest.domain.usecase.LoginUseCase
import com.example.androidtest.presentation.list.ListViewModel
import com.example.androidtest.presentation.login.LoginViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakeApiService : ApiService {
    override suspend fun login(request: LoginRequestDto): LoginResponseDto {
        return LoginResponseDto(session = "mock-session-123")
    }

    override suspend fun getList(session: Map<String, String>): ListResponseDto {
        val sampleImages = listOf(
            ImageUrlDto(
                url3X3 = "https://dummyimage.com/300/09f/fff.png",
                url4X4 = "https://dummyimage.com/400/09f/fff.png"
            )
        )

        val references = listOf(
            BankReferenceDto(
                bank = "BANORTE",
                reference = "REF123456",
                aliasbank = "BNTE",
                images = sampleImages
            ),
            BankReferenceDto(
                bank = "SANTANDER",
                reference = "REF789012",
                aliasbank = "SANT",
                images = sampleImages
            )
        )

        return ListResponseDto(status = 0, arrayReferences = references)
    }
}

fun provideApiService(): ApiService {
    val useFake = true // Cambia a false para usar Retrofit real
    return if (useFake) {
        FakeApiService()
    } else {
        Retrofit.Builder()
            .baseUrl("https://ejemplo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
fun provideRepository(): Repository = RepositoryImpl(provideApiService())
fun provideLoginVM() = LoginViewModel(LoginUseCase(provideRepository()))
fun provideListVM() = ListViewModel(GetReferencesUseCase(provideRepository()))