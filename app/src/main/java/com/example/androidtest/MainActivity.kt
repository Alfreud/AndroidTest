package com.example.androidtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.androidtest.di.provideListVM
import com.example.androidtest.di.provideLoginVM
import com.example.androidtest.presentation.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavigation(
                    loginViewModel = provideLoginVM(),
                    listViewModel = provideListVM()
                )
            }
        }
    }
}