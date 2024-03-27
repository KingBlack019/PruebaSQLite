package com.example.pruebasqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Database (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "VSHOP.db"
        // Definir las tablas y columnas de la base de datos
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Crear las tablas necesarias cuando se crea la base de datos
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Actualizar la base de datos si es necesario
    }
}