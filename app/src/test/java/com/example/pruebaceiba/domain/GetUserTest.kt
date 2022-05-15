package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.UserRepository
import com.example.pruebaceiba.data.model.UserModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetUserTest{

    @RelaxedMockK
    private lateinit var userRepository: UserRepository

    lateinit var getUser: GetUser

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getUser = GetUser(userRepository)
    }

    @Test
    fun `when the api doesnt return anything then get values from database`() = runBlocking {

        coEvery { userRepository.getAllUsersFromApi() } returns emptyList()

        getUser()

        coVerify(exactly = 0) { userRepository.clearUsers() }
        coVerify(exactly = 0) { userRepository.insertUsers(any()) }
        coVerify(exactly = 1) { userRepository.getAllUsersFromDatabase() }
    }


    @Test
    fun `when the api return something then get values from api`() = runBlocking {

        val userList = listOf(User("prueba", 1,"prueba","prueba","prueba","prueba"))

        coEvery { userRepository.getAllUsersFromApi() } returns userList

        val response = getUser()

        coVerify(exactly = 1) { userRepository.clearUsers() }
        coVerify(exactly = 1) { userRepository.insertUsers(any()) }
        coVerify(exactly = 0) { userRepository.getAllUsersFromDatabase() }

        assert(response==userList)
    }

}