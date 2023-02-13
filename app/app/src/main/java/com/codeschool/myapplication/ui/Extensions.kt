package com.codeschool.myapplication.ui

import androidx.fragment.app.Fragment
import com.codeschool.guardian.favorite.BaseFavoriteViewModel
import com.codeschool.myapplication.ui.guardian.GuardianNewsActivity

val Fragment.newsActivity: GuardianNewsActivity?
    get() = activity as? GuardianNewsActivity

val Fragment.favoritesViewModel: BaseFavoriteViewModel?
    get() = newsActivity?.favoriteViewModel