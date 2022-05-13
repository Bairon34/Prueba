package com.example.pruebaceiba.data

import com.example.pruebaceiba.data.database.dao.UserDao
import com.example.pruebaceiba.data.database.entities.UserEntity
import com.example.pruebaceiba.data.model.UserModel
import com.example.pruebaceiba.data.network.UserService
import com.example.pruebaceiba.domain.User
import com.example.pruebaceiba.domain.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private val userDao: UserDao
) {

    suspend fun getAllUsersFromApi(): List<User> {
        val response: List<UserModel> = api.getUsers()
        return response.map { it.toDomain() }
    }

    suspend fun getAllUsersFromDatabase():List<User>{
        val response: List<UserEntity> = userDao.getAllUser()
        return response.map { it.toDomain() }
    }


    suspend fun getAllUsersSearchsDatabase(wordSearchs: String):List<User>{
        val response: List<UserEntity> = userDao.getAllUserSearchs(wordSearchs)
        return response.map { it.toDomain() }
    }

    suspend fun insertUsers(quotes:List<UserEntity>){
        userDao.insertAll(quotes)
    }

    suspend fun clearUsers(){
        userDao.deleteAllQuotes()
    }



}