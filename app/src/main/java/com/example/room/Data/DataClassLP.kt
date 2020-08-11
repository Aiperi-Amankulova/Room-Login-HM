package com.example.room.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataClassLP (
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    var etFirst : String,
    var etSecond : String
)