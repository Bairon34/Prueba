package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetDataSearchsTest{
    @RelaxedMockK
    private lateinit var userRepository: UserRepository

    lateinit var getDataSearchs: GetDataSearchs

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getDataSearchs = GetDataSearchs(userRepository)
    }

    @Test
    fun `when the word does not match the name column data base`() = runBlocking {
        val WORD = "prueba"

        coEvery { userRepository.getAllUsersSearchsDatabase(WORD)} returns emptyList()
        val response = getDataSearchs(WORD)
        assert(response == null)
    }

    @Test
    fun `when database return something then return listUser`() = runBlocking {
        val WORD = "prueba"

        val userList = listOf(User("prueba", 1,"prueba","prueba","prueba","prueba"))
        coEvery { userRepository.getAllUsersSearchsDatabase(WORD)} returns userList
        val response = getDataSearchs(WORD)
        assert(response == userList)
    }





}