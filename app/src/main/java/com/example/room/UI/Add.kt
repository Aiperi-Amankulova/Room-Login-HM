package com.example.room.UI

import android.app.Application
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

    fun getDB() = database

    companion object {
        var add: Add? = null
    }
}