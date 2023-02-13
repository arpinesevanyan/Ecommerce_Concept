package com.codeschool.ecommerce

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codeschool.common.BaseCommonViewModel
import com.codeschool.common.network.ResultCallback
import com.codeschool.ecommerce.data.ECommerceDto
import com.codeschool.ecommerce.data.HomeStoreDto
import com.codeschool.ecommerce.model.ShowPicturesEnum
import com.codeschool.ecommerce.repository.ECommerceRepository


open class BaseECommerceViewModel(private val repository: ECommerceRepository) : BaseCommonViewModel(){
    private val _resultLiveData: MutableLiveData<List<ECommerceDto>> = MutableLiveData()
    val resultLiveData: LiveData<List<ECommerceDto>>
        get() = _resultLiveData

    fun getContentECommerce(
        pageNumber: Int = 20,
        showPicturesEnum: ShowPicturesEnum=ShowPicturesEnum.PICTURE
    ){
        repository.getContentECommerce(pageNumber, showPicturesEnum,
            object : ResultCallback<ECommerceDto?>{
                override fun onSuccess(data: ECommerceDto?) {

                }
        })
    }
}

