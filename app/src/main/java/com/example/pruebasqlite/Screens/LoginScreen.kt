package com.example.pruebasqlite.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.pruebasqlite.Data.uiStateUser
import com.example.pruebasqlite.GeneralFunctions.VerticalMidSpacer
import com.example.pruebasqlite.GeneralFunctions.VerticalBigSpacer
import com.example.pruebasqlite.GeneralFunctions.ViewModelUsuario

@Composable
fun LoginScreen(
    viewModelUsuario: ViewModelUsuario,
    uiStateUsuario: uiStateUser,
    clickRegister: () -> Unit,
    clickContinue: () -> Unit
){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, 
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Nombre de usuario")
        VerticalMidSpacer()
        //TextField(value = "", onValueChange = "") // todo variables que cambian 1
        VerticalBigSpacer()
        Text(text = "Contraseña")
        VerticalMidSpacer()
        //TextField(value = "", onValueChange = "") // todo variables que cambian 2
        VerticalMidSpacer()
        Button(
            onClick = { clickContinue.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)) {
            Text(text = "Enviar")
        }
        Row {
            Spacer(modifier = Modifier.width(50.dp))
            ClickableText(text = AnnotatedString("Registrarse", spanStyle = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Blue)), onClick = {clickRegister.invoke()})
        }

    }

}
