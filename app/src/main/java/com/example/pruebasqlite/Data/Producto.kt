package com.example.pruebasqlite.Data

data class Producto(
    val nombre: String,
    val precio: Double,
    val cantidad: Int = 1,
    val descripcion: String,
    val talla: String
)
