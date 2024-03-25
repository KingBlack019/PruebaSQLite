package com.example.pruebasqlite.generalFunctions

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pruebasqlite.Data.uiStateUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelUsuario : ViewModel() {

    private val _uiState = MutableStateFlow(uiStateUser())
    val uiState: StateFlow<uiStateUser> = _uiState.asStateFlow()

    fun setUsername(username: String) {
        _uiState.update { currentState ->
            currentState.copy( username = username)
        }
    }

    fun setPassword(password: String) {
        _uiState.update { currentState ->
            currentState.copy( password = password)
        }

    }

    fun insertarDatos() {
    }
}