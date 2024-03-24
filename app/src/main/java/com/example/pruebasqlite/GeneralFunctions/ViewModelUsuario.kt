package com.example.pruebasqlite.GeneralFunctions

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pruebasqlite.Data.uiStateUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelUsuario : ViewModel() {
    fun insertarDatos() {
        TODO("Not yet implemented")
    }

    private val _uiState = MutableStateFlow(uiStateUser())
    val uiState: StateFlow<uiStateUser> = _uiState.asStateFlow()

}