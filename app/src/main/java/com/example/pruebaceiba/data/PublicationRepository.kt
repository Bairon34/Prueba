package com.example.pruebaceiba.data

import com.example.pruebaceiba.data.model.PublicationModel
import com.example.pruebaceiba.data.network.PublicationService
import com.example.pruebaceiba.domain.model.Publication
import com.example.pruebaceiba.domain.model.toDomain
import javax.inject.Inject

class PublicationRepository @Inject constructor(
    private val api: PublicationService
    ) {

    suspend fun getAllPublicationsFromApi(USER_ID: Int): List<Publication> {
        val response: List<PublicationModel> = api.getPublications(USER_ID)
        return response.map { it.toDomain() }
    }
}