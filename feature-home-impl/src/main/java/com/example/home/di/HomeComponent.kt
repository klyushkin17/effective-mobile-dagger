package com.example.home.di

import com.example.core_network_api.NetworkApi
import com.example.home.presentation.TestFragment
import dagger.Component

@Component(
    modules = [HomeRepositoryModule::class],
    dependencies = [HomeDependenciesProvider::class]
)
interface HomeComponent: NetworkApi {

    @Component.Factory
    interface Factory {
        fun create(
            homeDependenciesProvider: HomeDependenciesProvider,
        ): HomeComponent
    }

    companion object {

        @Volatile
        private var homeComponent: HomeComponent? = null

        fun init(deps: HomeDependenciesProvider): HomeComponent {
            if (homeComponent == null) {
                homeComponent = DaggerHomeComponent
                    .factory()
                    .create(deps)
            }
            return requireNotNull(homeComponent)
        }
    }

    fun injectIntoTestFragment(testFragment: TestFragment)
}