package com.example.pruebaceiba.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaceiba.data.database.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY  id DESC")
    suspend fun getAllUser():List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user:List<UserEntity>)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllQuotes()
}