package com.example.hiltsampleapp.di

import android.content.Context
import androidx.room.Room
import com.example.hiltsampleapp.data.AppDataBase
import com.example.hiltsampleapp.data.LoginDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ActivityRetainedComponent::class)
@Module
object DataBaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext applicationContext: Context): AppDataBase {
        return  Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "login.db"
        ).build()
    }

    @Provides
    fun provideLoginDao(database: AppDataBase):LoginDao{
        return database.loginDao()
    }
}