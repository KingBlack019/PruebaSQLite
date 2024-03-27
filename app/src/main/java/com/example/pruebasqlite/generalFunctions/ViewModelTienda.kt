package com.example.pruebasqlite.generalFunctions

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pruebasqlite.Data.Producto
import com.example.pruebasqlite.Data.Tienda
import com.example.pruebasqlite.Data.uiStateUser
import com.example.pruebasqlite.Data.uiStateVshop
import com.example.pruebasqlite.database.Database
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelTienda: ViewModel() {
    private val _uiState = MutableStateFlow(uiStateVshop())
    val uiState: StateFlow<uiStateVshop> = _uiState.asStateFlow()
    var listaTienda by mutableStateOf<List<Tienda>>(emptyList()) // una lista de productos escogidos por la tienda seleccionada


    // Obtiene una lista de tiendas
    fun obtenerTiendas(context: Context){
        val dbHelper = Database(context)
        val db = dbHelper.readableDatabase
        val consulta = db.rawQuery("SELECT * FROM tienda", null)

        val listaTemporal = mutableListOf<Tienda>()
        with(consulta){// con la consulta realizada mientras que tenga filas y pase a la siguiente, se extraen los datos de la tienda
            while (moveToNext()){
                val idTienda = getString(getColumnIndexOrThrow("idTienda"))
                val nombreTienda = getString(getColumnIndexOrThrow("nombreTienda"))
                val descripcion = getString(getColumnIndexOrThrow("descripcion"))
                val direccion = getString(getColumnIndexOrThrow("direccion"))
                val tipo = getString(getColumnIndexOrThrow("tipo"))
                listaTemporal.add(Tienda(idTienda, nombreTienda, descripcion, direccion, tipo))
            }
        }
        listaTienda = listaTemporal
        consulta.close()
        db.close()
    }

}