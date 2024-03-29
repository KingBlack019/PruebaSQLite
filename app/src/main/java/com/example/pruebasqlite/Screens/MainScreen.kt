package com.example.pruebasqlite.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pruebasqlite.Data.*
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
    logoApiService: LogoApiService,
    tienda: ArrayList<Tienda>,
    clickContinue: () -> Unit,


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
        ListaTienda(viewModelTienda, logoApiService, tienda, clickContinue)
        VerticalMidSpacer()
    }
}

@Composable
fun ListaTienda(
    viewModelTienda: ViewModelTienda,
    logoApiService: LogoApiService,
    tienda: ArrayList<Tienda>,
    clickContinue: () -> Unit
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)){

        items(tienda) { tienda ->
            Card (modifier = Modifier.padding(16.dp).background(Color.White).clickable{
                viewModelTienda.asignarTienda(tienda) // TODO COMPROBAR QUE ESTO FUNCIONA
                clickContinue.invoke()
                },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 2.dp, color = Color.LightGray)
            ){
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(text = tienda.nombreTienda)// TODO NOMBRE DE LA TIENDA DE LA LISTA DE TIENDAS
                    LoadImageFromUrl(url = logoApiService.BASE_URL+tienda.nombreTienda+".com")
                }
            }

        }
    }
}
