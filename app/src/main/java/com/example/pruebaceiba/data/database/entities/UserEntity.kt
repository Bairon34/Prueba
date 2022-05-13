package com.example.pruebaceiba.data.database.entities

import android.service.autofill.UserData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebaceiba.domain.User


@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "website") val website: String,

  )


fun User.toDatabase() = UserEntity(
    id = id,
    name =  name,
    phone = phone,
    email =email,
    username = username ,
    website = website,
)
