package com.example.pruebaceiba.data.network

import com.example.pruebaceiba.data.model.PublicationModel
import com.example.pruebaceiba.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiClient {

    @GET("/users")
    suspend fun getAllUsers(): Response<List<UserModel>>

    @GET("/posts?")
    suspend fun getPublicationUser(@Query("userId") userId: Int): Response<List<PublicationModel>>
}