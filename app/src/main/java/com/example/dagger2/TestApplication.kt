package com.example.dagger2

import android.app.Application
import com.example.core.di.NetworkComponent
import com.example.home.di.HomeDependenciesProvider
import retrofit2.Retrofit

class TestApplication:
    Application(),
    HomeDependenciesProvider {

    override fun getRetrofit(): Retrofit {
        return NetworkComponent.init().provideRetrofit()
    }
}