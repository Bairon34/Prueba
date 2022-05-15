package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.UserRepository
import javax.inject.Inject

class GetDataSearchs @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(wordSearchs: kotlin.String): List<User>?  {
        val users = repository.getAllUsersSearchsDatabase(wordSearchs)

        if (!users.isNullOrEmpty()) {
            return users
        }
        return null
    }

}