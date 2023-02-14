package com.example.networkapp.data

import com.example.networkapp.data.models.CatResponse
import com.example.networkapp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl : Repository {
    override suspend fun getImage(breed: String): List<CatResponse> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CatService::class.java)
        return withContext(Dispatchers.IO) {
            service.getCatImage(breed).execute().body() ?: throw Exception()
        }
    }
}