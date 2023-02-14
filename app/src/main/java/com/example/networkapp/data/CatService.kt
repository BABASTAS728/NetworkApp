package com.example.networkapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("images/search")

    fun getCatImage(@Query("breed_ids") breed: String): Call<List<CatResponse>>
}
