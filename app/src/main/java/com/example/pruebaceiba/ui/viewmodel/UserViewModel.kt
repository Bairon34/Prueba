package com.example.pruebaceiba.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaceiba.domain.GetData
import com.example.pruebaceiba.domain.GetDataSearchs
import com.example.pruebaceiba.domain.GetUser
import com.example.pruebaceiba.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUser: GetUser,
    private val getData: GetData,
    private val getDataSearch: GetDataSearchs

) : ViewModel() {

    val userModel = MutableLiveData<List<User>>()
    val isLoading = MutableLiveData<Boolean>()
    var isSearch = MutableLiveData<Boolean>()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUser()
            if (!result.isNullOrEmpty()) {
                userModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun getDataLocal() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getData()
            if (result != null) {
                userModel.postValue(result!!)
            }
            isLoading.postValue(false)
        }
    }

    fun getSearchData(wordSearchs: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            if (wordSearchs.isNotEmpty()) {
                getSearchWidthWord(wordSearchs)
            }else{
                getDataLocal()
            }
            isLoading.postValue(false)
        }
    }

    private suspend fun getSearchWidthWord(wordSearch: String) {
        val result = getDataSearch.invoke(wordSearch)
        if (result != null) {
            isSearch.postValue(false)
            userModel.postValue(result!!)
        }else{
            isSearch.postValue(true)
        }

    }

}


