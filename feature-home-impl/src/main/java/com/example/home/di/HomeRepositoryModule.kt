package com.example.home.di

import com.example.home.data.repository.RepositoryImpl
import com.example.home.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module
interface HomeRepositoryModule {

    @Binds
    fun bindRepositoryImpl(repositoryImpl: RepositoryImpl): Repository
}