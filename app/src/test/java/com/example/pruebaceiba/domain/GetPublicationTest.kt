package com.example.pruebaceiba.domain

import com.example.pruebaceiba.data.PublicationRepository
import com.example.pruebaceiba.data.UserRepository
import com.example.pruebaceiba.domain.model.Publication
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetPublicationTest{

    @RelaxedMockK
    private lateinit var publicationRepository: PublicationRepository

    lateinit var getPublication: GetPublication

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getPublication = GetPublication(publicationRepository)
    }


    @Test
    fun `when the api doesnt return anything then get values from api`() = runBlocking {

        val ID_USER =1

        coEvery { publicationRepository.getAllPublicationsFromApi(ID_USER) } returns emptyList()
        val response = getPublication(ID_USER)
        assert(response == null)
    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {

        val ID_USER =1

        val publicationListList = listOf(Publication("prueba", 1,"prueba",1))
        coEvery { publicationRepository.getAllPublicationsFromApi(ID_USER) } returns publicationListList
        val response = getPublication(ID_USER)
        assert(response == publicationListList)
    }

}