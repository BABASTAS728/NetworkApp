package com.example.networkapp.domain

import com.example.networkapp.data.models.CatResponse

interface Repository {
    suspend fun getImage(breed: String): List<CatResponse>
}