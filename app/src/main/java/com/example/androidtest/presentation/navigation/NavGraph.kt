package com.example.androidtest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidtest.presentation.list.ListScreen
import com.example.androidtest.presentation.list.ListViewModel
import com.example.androidtest.presentation.login.LoginScreen
import com.example.androidtest.presentation.login.LoginViewModel

@Composable
fun AppNavigation(loginViewModel: LoginViewModel, listViewModel: ListViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {
        composable("login") {
            LoginScreen(viewModel = loginViewModel) { session ->
                listViewModel.load(session)
                navController.navigate("list")
            }
        }
        composable("list") {
            ListScreen(viewModel = listViewModel)
        }
    }
}