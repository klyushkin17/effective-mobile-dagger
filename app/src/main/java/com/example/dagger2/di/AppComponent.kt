package com.example.dagger2.di

import com.example.home.di.HomeDependenciesProvider
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent: HomeDependenciesProvider {

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}