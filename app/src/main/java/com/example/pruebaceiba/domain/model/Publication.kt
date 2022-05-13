package com.example.pruebaceiba.domain.model

import com.example.pruebaceiba.data.model.PublicationModel

data class Publication(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PublicationModel.toDomain() = Publication(body, id,title,userId)