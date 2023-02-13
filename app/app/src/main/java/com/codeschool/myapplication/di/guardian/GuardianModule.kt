package com.codeschool.myapplication.di.guardian

import com.codeschool.guardian.favorite.BaseFavoriteViewModel
import com.codeschool.myapplication.ui.guardian.GuardianNewsActivity
import com.codeschool.myapplication.ui.guardian.news.GuardianNewsViewModel
import com.codeschool.myapplication.ui.guardian.details.DetailsFragment
import com.codeschool.myapplication.ui.guardian.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val guardianModule = module {

    scope(named<GuardianNewsActivity>()) {
        viewModel { BaseFavoriteViewModel(get()) }
    }

    scope(named<GuardianNewsViewModel>()) {
        viewModel { GuardianNewsViewModel(get()) }
    }

    scope(named<DetailsFragment>()) {
        viewModel { DetailsViewModel(get()) }
    }
}