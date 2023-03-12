package com.example.networkapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkapp.data.models.CatResponse
import com.example.networkapp.domain.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _catLiveData = MutableLiveData<List<CatResponse>>()
    val catLiveData: LiveData<List<CatResponse>> get() = _catLiveData

    fun getCatImage(breed: String) {
        viewModelScope.launch {
            _catLiveData.value = repository.getImage(breed)
        }
    }
}