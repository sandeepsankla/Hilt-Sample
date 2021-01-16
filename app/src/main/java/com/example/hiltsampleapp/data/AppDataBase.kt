package com.example.hiltsampleapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Login::class), version = 1)

abstract class AppDataBase :RoomDatabase() {
    abstract fun loginDao():LoginDao
}