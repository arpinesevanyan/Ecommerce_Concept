package com.codeschool.ecommerce.data

import com.google.gson.annotations.SerializedName


data class EcommerceDto(
    @SerializedName("best_seller") val best_seller: List<BestSellerDto>,
    @SerializedName("home_store") val home_store: List<HomeStoreDto>
)

data class BestSellerDto(
    @SerializedName("discount_price") val discount_price: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val is_favorites: Boolean,
    @SerializedName("picture") val picture: String,
    @SerializedName("price_without_discount") val price_without_discount: Int,
    @SerializedName("title") val title: String
)

data class HomeStoreDto(
    @SerializedName("id") val id: Int,
    @SerializedName("is_buy") val is_buy: Boolean,
    @SerializedName("is_new") val is_new: Boolean,
    @SerializedName("picture") val picture: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("title") val title: String
)