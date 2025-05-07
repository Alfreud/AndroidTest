package com.example.androidtest.data.remote.dto

data class LoginRequestDto(val user: String, val password: String)
data class LoginResponseDto(val session: String)