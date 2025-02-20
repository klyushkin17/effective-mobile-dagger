package com.example.dagger2

import android.app.Application
import com.example.dagger2.di.AppComponent
import com.example.dagger2.di.DaggerAppComponent
import com.example.home.di.HomeDependenciesProvider
import retrofit2.Retrofit

class TestApplication:
    Application(),
    HomeDependenciesProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create()
    }

    override fun getBookRetrofit(): Retrofit = appComponent.getBookRetrofit()

    override fun getVacancyRetrofit(): Retrofit = appComponent.getVacancyRetrofit()
}