package com.codeschool.ecommerce.di

import com.codeschool.common.network.createWebService
import com.codeschool.ecommerce.api.EcommerceApi
import com.codeschool.ecommerce.repository.ECommerceRepository
import com.codeschool.ecommerce.repository.ECommerceRepositoryImpl
import com.codeschool.ecommerce.utils.ECommerceConstants
import org.koin.dsl.module

fun ecommerceModule() = module {
    single { createWebService<EcommerceApi> (ECommerceConstants.BASE_URL) }

    single<ECommerceRepository> {ECommerceRepositoryImpl(get())}

    single {  }
}