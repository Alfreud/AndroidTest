package com.example.androidtest.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidtest.domain.model.BankReference
import com.example.androidtest.presentation.common.UiState

@Composable
fun LoginScreen(viewModel: LoginViewModel, onSuccess: (String) -> Unit) {
    val state = viewModel.uiState
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center) {
        TextField(value = user, onValueChange = { user = it }, label = { Text("Usuario") })
        Spacer(Modifier.height(8.dp))
        TextField(value = pass, onValueChange = { pass = it }, label = { Text("Contraseña") })
        Spacer(Modifier.height(8.dp))
        Button(onClick = { viewModel.login(user, pass) }) { Text("Login") }

        when (state) {
            is UiState.Loading -> CircularProgressIndicator()
            is UiState.Error -> Text("Error: ${(state as UiState.Error).message}", color = Color.Red)
            is UiState.Success -> {
                val session = (state as UiState.Success<*>).data as String
                LaunchedEffect(Unit) {
                    onSuccess(session)
                }
            }
            else -> {}
        }
    }
}