package com.alkemy.ongsomosmas.data.home.news

import com.alkemy.ongsomosmas.data.BaseDataSource
import javax.inject.Inject

class NewsDataSource @Inject constructor(private val newsService: NewsService) : BaseDataSource() {

    suspend fun getNews() =
        getResult { newsService.getNews() }
}