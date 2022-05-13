package com.example.pruebaceiba.ui.viewmodel

import android.util.Log
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


    fun getSearchsData(wordSearchs: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            if (wordSearchs.isNotEmpty()) {
                val result = getDataSearch.invoke(wordSearchs)
                if (result != null) {
                    userModel.postValue(result!!)
                }
            }else{
                getDataLocal()
            }
            isLoading.postValue(false)
        }
    }


}


