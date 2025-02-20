package com.example.dagger2.di

import com.example.core.di.NetworkComponent
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return NetworkComponent.init().provideRetrofit()
    }
}