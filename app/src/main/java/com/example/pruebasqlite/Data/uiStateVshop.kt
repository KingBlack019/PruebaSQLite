package com.example.pruebasqlite.Data

data class uiStateVshop(
    var tiendaEscogida: Tienda = Tienda(),
    var carritoProductos: ArrayList<Producto> = ArrayList()
)
