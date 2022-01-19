package com.alkemy.ongsomosmas.ui.home.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.model.NewsResponse
import com.alkemy.ongsomosmas.databinding.FragmentNewsBinding
import com.alkemy.ongsomosmas.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment(R.layout.fragment_news)  {
    private lateinit var binding: FragmentNewsBinding

    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        //Get all news
        newsViewModel.getAllNews()

        setUpObservers()

        return binding.root
    }

    private fun setUpObservers() {
        showProgressDialog()
        newsViewModel.newsViewState.observe(viewLifecycleOwner) {
            when (it) {
                is NewsState.Success -> setDataAndShowRecycler(it.newsList)
                is NewsState.Error -> setListenerAndShowNewsError()
                is NewsState.Loading -> showLoading(it.isLoading)
            }
        }
    }

    private fun showLoading(loading: Boolean) {
//        TODO("loading spinner")
    }

    private fun setListenerAndShowNewsError() {
        hideProgressDialog()
        with(binding) {
            rvNewsFragment.isVisible = false
            newsFragmentError.root.isVisible = true
            newsFragmentError.tvError.text = getString(R.string.news_error_fragment)
            newsFragmentError.btnRetry.setOnClickListener {
                newsViewModel.getAllNews()
                newsFragmentError.root.isVisible = false
                showProgressDialog()
            }
        }
    }

    private fun setDataAndShowRecycler(newsList: List<NewsResponse>) {
        hideProgressDialog()
        NewsFragmentAdapter(newsList, requireContext()).let {
            with(binding.rvNewsFragment) {
                adapter = it
                isVisible = true
            }
        }
    }

}