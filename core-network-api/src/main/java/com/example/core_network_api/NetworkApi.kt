package com.example.core_network_api

import com.example.core.utils.BookRetrofit
import com.example.core.utils.VacancyRetrofit
import retrofit2.Retrofit

interface NetworkApi {

    @BookRetrofit
    fun provideBookRetrofit(): Retrofit

    @VacancyRetrofit
    fun provideVacancyRetrofit(): Retrofit
}