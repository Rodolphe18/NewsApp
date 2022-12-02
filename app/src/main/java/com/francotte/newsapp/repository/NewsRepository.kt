package com.francotte.newsapp.repository

import com.francotte.newsapp.Constants
import com.francotte.newsapp.retrofit.NewsInterface
import com.francotte.newsapp.retrofit.response.Article
import com.francotte.newsapp.retrofit.response.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(val newsInterface: NewsInterface)  {

    suspend fun getAllNews() : Flow<NewsResponse> {
       return flow {
            emit(newsInterface.getAllNews("US", "business", Constants.API_KEY))
        }
    }

}