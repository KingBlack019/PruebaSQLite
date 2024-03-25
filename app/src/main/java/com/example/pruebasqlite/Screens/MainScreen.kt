package com.example.pruebasqlite.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pruebasqlite.Data.uiStateUser
import com.example.pruebasqlite.generalFunctions.ViewModelUsuario

@Composable
fun MainScreen(
    viewModelUsuario: ViewModelUsuario,
    uiStateUsuario: uiStateUser
){
    Column (modifier = Modifier.fillMaxSize()){
        Text(
            text = "Hola ${uiStateUsuario.username}!",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
        )
        ListaTienda()


    }
}

@Composable
fun ListaTienda() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)){

        /*
        items(itemsList) { tienda ->

        }
     Card (modifier = Modifier.padding(16.dp)){
        Row (modifier = Modifier.fillMaxWidth()){
            Text(text = "")// TODO NOMBRE DE LA TIENDA DE LA LISTA DE TIENDAS
            // TODO IMAGEN DEL TEXTO
            Button(
                onClick = { /* TODO ACCEDER A DICHA TIENDA */ },
                modifier = Modifier.padding(16.dp)) {
                Text(text = "Entrar")
            }
        }
     }*/
    }
}
