package com.example.pruebaceiba.data.network

import com.example.pruebaceiba.data.model.PublicationModel
import com.example.pruebaceiba.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PublicationService @Inject constructor(
    private val api:UserApiClient
) {
    suspend fun getPublications(USER_ID: Int): List<PublicationModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getPublicationUser(USER_ID)
            response.body() ?: emptyList()
        }
    }
}