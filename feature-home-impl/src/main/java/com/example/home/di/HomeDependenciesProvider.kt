package com.example.home.di

import retrofit2.Retrofit

interface HomeDependenciesProvider {

    fun getRetrofit(): Retrofit
}
