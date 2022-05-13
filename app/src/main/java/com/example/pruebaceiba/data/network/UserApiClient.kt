package com.example.pruebaceiba.data.network

import com.example.pruebaceiba.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {

    @GET("/users")
    suspend fun getAllUsers(): Response<List<UserModel>>
}