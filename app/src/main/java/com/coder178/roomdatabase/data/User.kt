package com.coder178.roomdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName: String,
    val lastName:String,
    val age:Int
)