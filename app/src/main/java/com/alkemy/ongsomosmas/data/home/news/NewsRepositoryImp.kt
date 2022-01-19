package com.alkemy.ongsomosmas.data.home.news

import javax.inject.Inject

class NewsRepositoryImp @Inject constructor(private val newsDataSource: NewsDataSource): NewsRepository {
    override suspend fun getNews() =
        newsDataSource.getNews()
}