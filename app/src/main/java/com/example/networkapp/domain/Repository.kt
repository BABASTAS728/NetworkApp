package com.example.networkapp.domain

import com.example.networkapp.data.CatResponse
import retrofit2.Call

interface Repository {
    suspend fun getImage(): List<CatResponse>
}