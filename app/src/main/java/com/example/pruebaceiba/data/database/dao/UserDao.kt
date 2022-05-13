package com.example.pruebaceiba.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaceiba.data.database.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    suspend fun getAllUser():List<UserEntity>

    @Query("SELECT * FROM user_table WHERE  name LIKE '%'|| :wordSearch ||'%'")
    suspend fun getAllUserSearchs(wordSearch: String):List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user:List<UserEntity>)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllQuotes()


}