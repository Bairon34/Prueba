package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.UserRepository
import javax.inject.Inject

class GetData  @Inject constructor(private val repository: UserRepository){

    suspend operator fun invoke(): List<User>?  {
        val users = repository.getAllUsersFromDatabase()
        if (!users.isNullOrEmpty()) {
            return users
        }
        return null
    }


}