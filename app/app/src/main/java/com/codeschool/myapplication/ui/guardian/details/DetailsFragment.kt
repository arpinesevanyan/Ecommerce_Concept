package com.codeschool.myapplication.ui.guardian.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import org.koin.androidx.scope.lifecycleScope
import com.codeschool.common.BaseCommonFragment
import com.codeschool.myapplication.databinding.FragmentDetailsBinding
import com.codeschool.myapplication.ui.favoritesViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.scope.viewModel

class DetailsFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by lifecycleScope.viewModel<DetailsViewModel>(this)
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.newsItem?.id?.let { viewModel.getDetails(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setUpListeners()
        observeLiveData()
    }

    private fun setUpListeners() {
        binding.fab.setOnClickListener {
            args.newsItem?.id?.let { id ->
                if (it.isSelected)
                    favoritesViewModel?.deleteNewsById(id)
                else {
                    viewModel.detailsLiveData.value?.let { dto -> favoritesViewModel?.saveNews(dto) }
                    view?.let { it1 ->
                        Snackbar.make(
                            it1,
                            "News saved successfully",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun setupViews() {
        binding.fab.isSelected =
            favoritesViewModel?.favoriteNews?.value?.find { it.id == args.newsItem?.id } != null
    }

    private fun observeLiveData() {
        viewModel.detailsLiveData.observe(viewLifecycleOwner) { contentDto ->
            with(binding) {
                Glide.with(requireActivity())
                    .load(contentDto?.fields?.thumbnail)
                    .into(detailImage)
                detailTitle.text = contentDto?.fields?.headline
                detailBody.text = contentDto?.fields?.body?.let {
                    HtmlCompat.fromHtml(
                        it,
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    )
                }
            }
        }
        favoritesViewModel?.favoriteNews?.observe(viewLifecycleOwner) { newsItem ->
            binding.fab.isSelected = newsItem.find { it.id == args.newsItem?.id } != null
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}
