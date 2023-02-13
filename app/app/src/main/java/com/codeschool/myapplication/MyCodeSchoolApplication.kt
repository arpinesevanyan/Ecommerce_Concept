package com.codeschool.myapplication

import com.codeschool.common.BaseCommonApplication
import com.codeschool.guardian.favorite.database.di.roomModule
import com.codeschool.guardian.favorite.di.favoriteNewsModule
import com.codeschool.guardian.news.di.newsModule
import com.codeschool.myapplication.di.guardian.guardianModule
import org.koin.core.module.Module

class MyCodeSchoolApplication : BaseCommonApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun getKoinModules(): List<Module> = listOf(
        newsModule(),
        guardianModule,
        roomModule,
        favoriteNewsModule,
    )

    fun setConnectionListener(listener: ConnectionReceiverListener) {
        ConnectionReceiver.connectionReceiverListener = listener
    }

    companion object {
        lateinit var instance: MyCodeSchoolApplication
    }
}


