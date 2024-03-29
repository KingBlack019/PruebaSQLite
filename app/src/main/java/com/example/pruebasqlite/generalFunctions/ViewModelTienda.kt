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
import kotlinx.coroutines.flow.update

class ViewModelTienda: ViewModel() {
    private val _uiState = MutableStateFlow(uiStateVshop())
    val uiState: StateFlow<uiStateVshop> = _uiState.asStateFlow()
    private var listaTienda: ArrayList<Tienda> = arrayListOf() // una lista de productos escogidos por la tienda seleccionada


    fun getFakeListaTienda(): ArrayList<Tienda>{
        listaTienda.add(Tienda("0001","nike","Tienda de ropa","nose","ROPA"))
        listaTienda.add(Tienda("0002","amazon","Tienda de productos","nose","GENERAL"))
        listaTienda.add(Tienda("0003","zara","Tienda de ropa","nose","ROPA"))
        listaTienda.add(Tienda("0004","pullandbear","Tienda de ropa","nose","ROPA"))
        listaTienda.add(Tienda("0005","microsoft","Tienda digital","nose","DIGITAL"))
        listaTienda.add(Tienda("0006","xiaomi","Tienda de dispositivos electronicos","","ELECTRONICA"))
        return listaTienda
    }


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
        listaTienda = ArrayList(listaTemporal)
        consulta.close()
        db.close()
    }

    fun asignarTienda(tiendaElegida: Tienda) {
        _uiState.update { currentState ->
            currentState.copy( tiendaEscogida = tiendaElegida)
        }
    }

}