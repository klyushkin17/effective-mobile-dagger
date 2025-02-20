package com.example.core.di

import com.example.core.utils.BaseUrls
import com.example.core.utils.BookRetrofit
import com.example.core.utils.VacancyRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @[Singleton Provides BookRetrofit]
    fun provideBookRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrls.BOOK_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @[Singleton Provides VacancyRetrofit]
    fun provideVacancyRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrls.VACANCY_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}

