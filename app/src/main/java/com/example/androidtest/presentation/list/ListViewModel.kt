package com.example.androidtest.presentation.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtest.domain.model.BankReference
import com.example.androidtest.domain.usecase.GetReferencesUseCase
import com.example.androidtest.presentation.common.UiState
import kotlinx.coroutines.launch

class ListViewModel(private val getReferencesUseCase: GetReferencesUseCase) : ViewModel() {
    var uiState by mutableStateOf<UiState<List<BankReference>>>(UiState.Idle)
    fun load(session: String) {
        viewModelScope.launch {
            uiState = UiState.Loading
            try {
                val data = getReferencesUseCase(session)
                uiState = UiState.Success(data)
            } catch (e: Exception) {
                uiState = UiState.Error(e.localizedMessage ?: "Error")
            }
        }
    }
}