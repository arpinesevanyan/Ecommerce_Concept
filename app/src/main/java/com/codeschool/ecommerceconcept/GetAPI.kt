package com.codeschool.ecommerceconcept

import retrofit2.Call

interface GetAPI {

    fun getData(): Call<List<ItemData>>
}