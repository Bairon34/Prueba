package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetDataTest{

    @RelaxedMockK
    private lateinit var userRepository: UserRepository

    lateinit var getData : GetData

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getData = GetData(userRepository)
    }

    @Test
    fun `when database is empty then return null`() = runBlocking {

        coEvery { userRepository.getAllUsersFromDatabase()} returns emptyList()
        val response = getData()
        assert(response == null)
    }

    @Test
    fun `when database return something then return listUser`() = runBlocking {

        val userList = listOf(User("prueba", 1,"prueba","prueba","prueba","prueba"))
        coEvery { userRepository.getAllUsersFromDatabase()} returns userList
        val response = getData()
        assert(response == userList)
    }



}