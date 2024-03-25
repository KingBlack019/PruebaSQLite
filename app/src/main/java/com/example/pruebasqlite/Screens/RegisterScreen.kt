package com.example.pruebasqlite.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pruebasqlite.Data.uiStateUser
import com.example.pruebasqlite.generalFunctions.ViewModelUsuario

@Composable
fun RegisterScreen(viewModelUsuario: ViewModelUsuario, uiStateUsuario: uiStateUser, clickContinue: () -> Unit) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Registrate ahora!",
            modifier = Modifier.fillMaxWidth()
        )

    }
}