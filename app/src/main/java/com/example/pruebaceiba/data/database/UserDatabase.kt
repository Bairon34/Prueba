package com.example.pruebaceiba.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebaceiba.data.database.dao.UserDao
import com.example.pruebaceiba.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase(){
    abstract fun getUserDao(): UserDao
}