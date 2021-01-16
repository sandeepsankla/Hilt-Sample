package com.example.hiltsampleapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao {
    @Query("SELECT * FROM login")
    fun getLoginDetails():Login

    @Insert
    fun insertDetails( login: Login)

}