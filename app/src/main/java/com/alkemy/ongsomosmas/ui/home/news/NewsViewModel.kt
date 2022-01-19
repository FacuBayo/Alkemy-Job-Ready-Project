package com.alkemy.ongsomosmas.ui.home.news

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.home.news.NewsRepositoryImp
import com.alkemy.ongsomosmas.data.model.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel @ViewModelInject constructor(private val newsRepositoryImp: NewsRepositoryImp) :
    ViewModel() {
    private val _news = MutableLiveData<Resource<List<NewsResponse>>>()
    val news: LiveData<Resource<List<NewsResponse>>> = _news

    private val _newsViewState = MutableLiveData<NewsState>()
    val newsViewState: LiveData<NewsState> = _newsViewState


    fun getNews() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                newsRepositoryImp.getNews()
            }
            _news.value = result
        }
    }

    fun getAllNews() {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                newsRepositoryImp.getNews()
            }.run {
                when (status) {
                    Resource.Status.SUCCESS -> {
                        _newsViewState.value = NewsState.Loading(false)
                        _newsViewState.value = data?.let { NewsState.Success(it) }
                    }
                    Resource.Status.ERROR -> {
                        _newsViewState.value = NewsState.Loading(false)
                        _newsViewState.value = NewsState.Error
                    }
                    Resource.Status.LOADING -> {
                        _newsViewState.value = NewsState.Loading(true)
                    }
                }
            }

        }
    }
}
sealed class NewsState {
    data class Success(val newsList: List<NewsResponse>) : NewsState()
    object Error : NewsState()
    data class Loading(val isLoading: Boolean) : NewsState()
}