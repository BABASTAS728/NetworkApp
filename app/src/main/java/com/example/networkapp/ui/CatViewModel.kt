package com.example.networkapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkapp.data.CatResponse
import com.example.networkapp.data.RepositoryImpl
import kotlinx.coroutines.launch

class CatViewModel: ViewModel() {
    private val _catLiveData = MutableLiveData<String?>()
    val catLiveData: LiveData<String?> get() = _catLiveData

    fun getCatImage() {
        viewModelScope.launch {
            _catLiveData.value = RepositoryImpl().getImage().get(0).imageUrl
        }
    }
}