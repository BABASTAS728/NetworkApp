package com.example.networkapp.data

import com.google.gson.annotations.SerializedName

data class CatResponse(
    @SerializedName("url") val imageUrl: String? = null
)
