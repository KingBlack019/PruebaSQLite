package com.example.pruebasqlite.Screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pruebasqlite.Data.LogoApiService
import com.example.pruebasqlite.Data.uiStateUser
import com.example.pruebasqlite.Data.uiStateVshop
import com.example.pruebasqlite.generalFunctions.VerticalBigSpacer
import com.example.pruebasqlite.generalFunctions.VerticalMidSpacer
import com.example.pruebasqlite.generalFunctions.ViewModelTienda
import com.example.pruebasqlite.generalFunctions.ViewModelUsuario


@Composable
fun MainScreen(
    viewModelUsuario: ViewModelUsuario,
    uiStateUsuario: uiStateUser,
    viewModelTienda: ViewModelTienda,
    uiStateVshop: uiStateVshop,
    logoApiService: LogoApiService
){
    Column (modifier = Modifier.fillMaxSize()){
        Text(
            text = "Hola ${uiStateUsuario.username}!",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
        )
        VerticalBigSpacer()
        Text(text = "Seleccione una tienda", modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally))
        VerticalMidSpacer()
        ListaTienda(viewModelTienda, logoApiService)
        VerticalMidSpacer()
        Button(
            onClick = { /* TODO ACCEDER A DICHA TIENDA */ },
            modifier = Modifier.padding(16.dp)) {
            Text(text = "Entrar")
        }
    }
}

@Composable
fun ListaTienda(viewModelTienda: ViewModelTienda, logoApiService: LogoApiService) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)){

        items(viewModelTienda.listaTienda) { tienda ->
            Card (modifier = Modifier.padding(16.dp)){
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(text = tienda.nombreTienda)// TODO NOMBRE DE LA TIENDA DE LA LISTA DE TIENDAS
                    Image(painter = painterResource(id = logoApiService.logoApiService), contentDescription = tienda.descripcion) // TODO IMAGEN DEL TEXTO

                }
            }

        }
    }
}
