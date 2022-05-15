package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.PublicationRepository
import com.example.pruebaceiba.domain.model.Publication
import javax.inject.Inject

class GetPublication @Inject constructor(
    private val repository: PublicationRepository
){
    suspend operator fun invoke(USER_ID: kotlin.Int): List<Publication>? {
        val publication = repository.getAllPublicationsFromApi(USER_ID)
        if(publication.isNotEmpty()){
          return  publication
        }
        return null
    }
}