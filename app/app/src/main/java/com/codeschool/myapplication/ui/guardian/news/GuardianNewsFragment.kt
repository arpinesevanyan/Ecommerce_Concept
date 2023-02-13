package com.codeschool.myapplication.ui.guardian.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codeschool.common.BaseCommonFragment
import com.codeschool.myapplication.databinding.FragmentGuardianNewsBinding
import com.codeschool.myapplication.ui.favoritesViewModel
import com.codeschool.myapplication.ui.guardian.GuardianNewsAdapter
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class GuardianNewsFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentGuardianNewsBinding
    lateinit var newsAdapter: GuardianNewsAdapter

    //    var isScrolling = false
    private val viewModel by lifecycleScope.viewModel<GuardianNewsViewModel>(this)

    private lateinit var scrollListener: RecyclerView.OnScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getGuardianNews()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuardianNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupListeners()
        observeLiveData()
        setupViews()
    }

    private fun setupViews() {
        newsAdapter = GuardianNewsAdapter {
            navigateFragment(GuardianNewsFragmentDirections.actionGuardianNewsFragmentToDetailsFragment(it))
        }
        binding.guardianNewsRecyclerView.apply {
            adapter = newsAdapter
//            addOnScrollListener(this@GuardianNewsFragment.scrollListener)
        }
    }

//    private fun setupListeners() {
//        scrollListener = object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
//                val visibleItemCount = layoutManager.childCount
//                val totalItemCount = layoutManager.itemCount
//
//                val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
//                val isNotAtBeginning = firstVisibleItemPosition >= 0
//                val shouldPaginate = isAtLastItem && isNotAtBeginning && isScrolling
//                if (shouldPaginate) {
//                    isScrolling = false
//                }
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                    isScrolling = true
//                }
//            }
//        }
//        setupRecyclerView()
//    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeLiveData() {
        viewModel.resultsLiveData.observe(viewLifecycleOwner) { it ->
            it?.let { result ->
                newsAdapter.updateData(result)
            }
        }
        favoritesViewModel?.favoriteNews?.observe(viewLifecycleOwner) {
            newsAdapter.notifyDataSetChanged()
        }
    }

//    private fun setupRecyclerView() {
//        newsAdapter = ContentNewsAdapter {
//            navigateFragment(ContentNewsFragmentDirections.actionContentNewsFragmentToDetailsFragment(it))
//        }
//        binding.contentNewsRecyclerView.apply {
//            adapter = newsAdapter
////            addOnScrollListener(this@ContentNewsFragment.scrollListener)
//        }
//    }

    companion object {
        @JvmStatic
        fun newInstance() = GuardianNewsFragment()
    }
}