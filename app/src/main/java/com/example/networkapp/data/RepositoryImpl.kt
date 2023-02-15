package com.example.networkapp.data

import com.example.networkapp.data.models.CatResponse
import com.example.networkapp.data.network.CatService
import com.example.networkapp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: CatService
): Repository {
    override suspend fun getImage(breed: String): List<CatResponse> {
        return withContext(Dispatchers.IO) {
            service.getCatImage(breed).execute().body() ?: throw Exception()
        }
    }
}