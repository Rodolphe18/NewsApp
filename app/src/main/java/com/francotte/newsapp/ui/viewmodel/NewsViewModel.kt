package com.francotte.newsapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.francotte.newsapp.repository.NewsRepository
import com.francotte.newsapp.retrofit.response.NewsResponse
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    private val _articles = MutableLiveData<NewsResponse>()
    val articles : LiveData<NewsResponse> = _articles

    init {
        getAllNews()
    }

    private fun getAllNews() {
        viewModelScope.launch {
            newsRepository.getAllNews().collect {
                _articles.postValue(it)
            }
        }
    }

}