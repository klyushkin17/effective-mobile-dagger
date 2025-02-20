package com.example.home.di

import com.example.core.utils.BookRetrofit
import com.example.core.utils.VacancyRetrofit
import retrofit2.Retrofit

interface HomeDependenciesProvider {

    @BookRetrofit
    fun getBookRetrofit(): Retrofit

    @VacancyRetrofit
    fun getVacancyRetrofit(): Retrofit
}
