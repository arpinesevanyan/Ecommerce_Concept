package com.codeschool.ecommerce.api

import com.codeschool.ecommerce.data.EcommerceDto
import com.codeschool.ecommerce.data.MyCartDto
import com.codeschool.ecommerce.data.ProductDetailsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EcommerceApi {
    @Headers("api-key:654bd15e-b121-49ba-a588-960956b15175")
    @GET("v3/")
    fun getECommerceContent(
        @Query("page-size") pageNumber: Int,
        @Query("picture") showPicture: String
    ): Call<EcommerceDto>
}

interface ProductDetailsApi {
    @Headers("api-key:654bd15e-b121-49ba-a588-960956b15175")
    @GET("v3/")
    fun getProductDetails(
        @Query("page-size") pageNumber: Int,
        @Query("picture") showPicture: String
    ): Call<ProductDetailsDto>
}


interface MyCartApi {
    @Headers("api-key:6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    @GET("v3/")
    fun getMyCartInfo(
        @Query("page-size") pageNumber: Int,
        @Query("picture") showPicture: String
    ): Call<MyCartDto>
}