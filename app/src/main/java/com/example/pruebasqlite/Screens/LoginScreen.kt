package com.example.pruebasqlite.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.pruebasqlite.Data.uiStateUser
import com.example.pruebasqlite.generalFunctions.VerticalBigSpacer
import com.example.pruebasqlite.generalFunctions.VerticalMidSpacer
import com.example.pruebasqlite.generalFunctions.ViewModelUsuario

@SuppressLint("StateFlowValueCalledInComposition")
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
        TextField(value = uiStateUsuario.username, onValueChange = { viewModelUsuario.setUsername(it) } )
        VerticalBigSpacer()
        Text(text = "Contraseña")
        VerticalMidSpacer()
        TextField(value = uiStateUsuario.password, onValueChange = { viewModelUsuario.setPassword(it) } )
        VerticalMidSpacer()
        Button(
            onClick = { clickContinue.invoke()
                      viewModelUsuario.insertarDatos()
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "Enviar")
        }
        VerticalMidSpacer()
        Row {
            Spacer(modifier = Modifier.width(60.dp))
            ClickableText(text = AnnotatedString("Registrarse", spanStyle = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Blue)), onClick = {clickRegister.invoke()})
        }
    }
}
