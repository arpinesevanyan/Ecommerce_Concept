package com.codeschool.myapplication.ui.guardian.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codeschool.common.BaseCommonFragment
import com.codeschool.myapplication.databinding.FragmentFavoriteBinding
import com.codeschool.myapplication.ui.favoritesViewModel
import com.codeschool.myapplication.ui.guardian.GuardianNewsAdapter

class FavoriteFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentFavoriteBinding
    lateinit var newsAdapter: GuardianNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        setupViews()
    }

    private fun setupViews() {
        newsAdapter = GuardianNewsAdapter {

        }
    }

    private fun observeLiveData() {
        favoritesViewModel?.favoriteNews?.observe(viewLifecycleOwner) {
            newsAdapter.updateData(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavoriteFragment()
    }
}