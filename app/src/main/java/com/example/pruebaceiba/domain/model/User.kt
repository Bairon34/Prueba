package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.database.entities.UserEntity
import com.example.pruebaceiba.data.model.UserModel


data class User(
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)



fun UserModel.toDomain() = User(email, id,name,phone,username,website)
fun UserEntity.toDomain() = User(email, id,name,phone,username,website)



