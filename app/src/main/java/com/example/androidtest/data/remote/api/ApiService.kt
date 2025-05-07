package com.example.androidtest.data.remote.api

import com.example.androidtest.data.remote.dto.ListResponseDto
import com.example.androidtest.data.remote.dto.LoginRequestDto
import com.example.androidtest.data.remote.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login.do")
    suspend fun login(@Body request: LoginRequestDto): LoginResponseDto

    @POST("listado.do")
    suspend fun getList(@Body session: Map<String, String>): ListResponseDto
}