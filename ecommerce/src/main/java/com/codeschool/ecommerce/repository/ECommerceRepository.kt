package com.codeschool.ecommerce.repository

import com.codeschool.common.network.ResultCallback
import com.codeschool.ecommerce.api.EcommerceApi
import com.codeschool.ecommerce.data.EcommerceDto
import com.codeschool.ecommerce.model.ShowPicturesEnum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ECommerceRepository{
    fun getContentECommerce(
        pageNumber: Int,
        showPicturesEnum : ShowPicturesEnum,
        resultCallback: ResultCallback<EcommerceDto?>
    )
}

class ECommerceRepositoryImpl(private val eCommerceApi: EcommerceApi) : ECommerceRepository{
    override fun getContentECommerce(
        pageNumber: Int,
        showPicturesEnum: ShowPicturesEnum,
        resultCallback: ResultCallback<EcommerceDto?>
    ) {
        eCommerceApi.getECommerceContent(pageNumber, showPicturesEnum.pictures)
            .enqueue(object : Callback<EcommerceDto> {
                override fun onResponse(
                    call: Call<EcommerceDto>,
                    response: Response<EcommerceDto>
                ) {
                    if (response.isSuccessful){
                        resultCallback.onSuccess(response.body())
                    } else {
                        resultCallback.onError(response.message())
                    }
                }
                override fun onFailure(call: Call<EcommerceDto>, t: Throwable) {
                    resultCallback.onError(t.message ?: "unknown failure")
                }
            })
    }
}