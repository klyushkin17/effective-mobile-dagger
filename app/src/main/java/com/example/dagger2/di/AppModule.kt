package com.example.dagger2.di

import com.example.core.di.NetworkComponent
import com.example.core.utils.BookRetrofit
import com.example.core.utils.VacancyRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AppModule {

    @[Provides BookRetrofit AppScope]
    fun provideBookRetrofit(): Retrofit = NetworkComponent.init().provideBookRetrofit()

    @[Provides VacancyRetrofit AppScope]
    fun provideVacancyRetrofit(): Retrofit = NetworkComponent.init().provideVacancyRetrofit()
}