package com.example.pruebaceiba.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaceiba.domain.GetPublication
import com.example.pruebaceiba.domain.GetUser
import com.example.pruebaceiba.domain.User
import com.example.pruebaceiba.domain.model.Publication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PublicationViewModel  @Inject constructor(
    private val getPublication: GetPublication,
): ViewModel(){

    val publicationModel = MutableLiveData<List<Publication>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(USER_ID: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPublication.invoke(USER_ID)
            if (!result.isNullOrEmpty()) {
                publicationModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }
}