package com.francotte.newsapp.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.francotte.newsapp.Constants.BASE_URL
import com.francotte.newsapp.R
import com.francotte.newsapp.repository.NewsRepository
import com.francotte.newsapp.retrofit.NewsInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DiModules {

    @Singleton
    @Provides
    fun provideNewsInterface(): NewsInterface {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(NewsInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideGlideInstance(
        @ApplicationContext context : Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )
    @Provides
    @Singleton
    fun provideRepository(newsInterface: NewsInterface) : NewsRepository {
        return NewsRepository(newsInterface)
    }




}