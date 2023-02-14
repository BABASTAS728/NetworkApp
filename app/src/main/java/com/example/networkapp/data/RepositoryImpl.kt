package com.example.networkapp.data

import com.example.networkapp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl: Repository {
    override suspend fun getImage(): List<CatResponse> {
        val retrofit  = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CatService::class.java)
        return withContext(Dispatchers.IO){ service.getCatImage(10).execute().body() ?: throw Exception()}
    }
}