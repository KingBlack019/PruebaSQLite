package com.example.pruebasqlite.generalFunctions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalMidSpacer(){
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun VerticalBigSpacer(){
    Spacer(modifier = Modifier.height(24.dp))
}