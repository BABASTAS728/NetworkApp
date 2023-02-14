package com.example.networkapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("images/search")

    fun getCatImage(@Query("limit") limit: Int): Call<List<CatResponse>>
}
