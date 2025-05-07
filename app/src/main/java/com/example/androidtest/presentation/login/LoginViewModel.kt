package com.example.androidtest.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtest.domain.usecase.LoginUseCase
import com.example.androidtest.presentation.common.UiState
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    var uiState by mutableStateOf<UiState<String>>(UiState.Idle)
    fun login(user: String, pass: String) {
        viewModelScope.launch {
            uiState = UiState.Loading
            try {
                val session = loginUseCase(user, pass)
                uiState = UiState.Success(session)
            } catch (e: Exception) {
                uiState = UiState.Error(e.localizedMessage ?: "Error")
            }
        }
    }
}