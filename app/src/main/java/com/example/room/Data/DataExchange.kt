package com.example.room.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataExchange {

    @Insert
    fun insertDataClassEdit(data: DataClass)

    @Query("SELECT * FROM DATACLASSEDIT")
    fun getallEditFromDataclass(): List<DataClass>
}