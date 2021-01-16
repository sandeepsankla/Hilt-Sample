package com.example.hiltsampleapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class Login(
     val userName :String,
     val password : String
){
     @PrimaryKey(autoGenerate = true)
     var id: Long = 0
}