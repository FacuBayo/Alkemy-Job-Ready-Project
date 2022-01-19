package com.alkemy.ongsomosmas.data.home.news

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.NewsResponse

interface NewsRepository {
    suspend fun getNews(): Resource<List<NewsResponse>>
}