package com.example.room.UI

import android.app.Application
import androidx.room.Room.databaseBuilder
import com.example.room.Data.DataClass2

class Add : Application() {

    private var database: DataClass2?=null

    override fun onCreate() {
        super.onCreate()
        add = this
        database= Room.databaseBuilder(this, DataClass2 :: class.java,"DataBase")
            .allowMainThreadQueries()
            .build()
    }

    fun getDataBase() = database

    companion object {
        var add: Add? = null
    }
}