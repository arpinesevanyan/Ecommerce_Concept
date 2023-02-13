package com.codeschool.ecommerce.data

import com.google.gson.annotations.SerializedName

data class MyCartDto(
    @SerializedName("basket") val basket: List<BasketDto>,
    @SerializedName("delivery") val delivery: String,
    @SerializedName("id") val id: String,
    @SerializedName("total") val total: Int
)

data class BasketDto(
    @SerializedName("id") val id: Int,
    @SerializedName("images") val images: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String
)