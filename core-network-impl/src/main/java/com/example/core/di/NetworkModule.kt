package com.example.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideBookRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummy.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}