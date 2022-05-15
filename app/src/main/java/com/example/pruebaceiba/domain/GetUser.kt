package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.UserRepository
import com.example.pruebaceiba.data.database.entities.toDatabase
import javax.inject.Inject

class GetUser  @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        val users = repository.getAllUsersFromApi()
        return if(users.isNotEmpty()){
            repository.clearUsers()
            repository.insertUsers(users.map { it.toDatabase() })
            users
        }else{
            repository.getAllUsersFromDatabase()
        }
    }

}