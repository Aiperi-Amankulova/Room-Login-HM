package com.example.room.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataClass::class], version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun getDaoInterface():DataExchange
}