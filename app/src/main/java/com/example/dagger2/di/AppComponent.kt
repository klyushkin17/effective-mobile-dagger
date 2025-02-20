package com.example.dagger2.di

import com.example.home.di.HomeDependenciesProvider
import dagger.Component
import javax.inject.Scope

@[Component(modules = [AppModule::class]) AppScope]
interface AppComponent: HomeDependenciesProvider {

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope