package com.codeschool.myapplication.ui.guardian

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.codeschool.common.BaseCommonActivity
import com.codeschool.guardian.favorite.BaseFavoriteViewModel
import com.codeschool.myapplication.R
import com.codeschool.myapplication.databinding.ActivityGuardianNewsBinding
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class GuardianNewsActivity : BaseCommonActivity() {
    private lateinit var binding: ActivityGuardianNewsBinding
    override fun noInternetView(): View = binding.noInternetTextView
    val favoriteViewModel by lifecycleScope.viewModel<BaseFavoriteViewModel>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardianNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setupWithNavController(this.findNavController(R.id.navHostFragment))
    }
}