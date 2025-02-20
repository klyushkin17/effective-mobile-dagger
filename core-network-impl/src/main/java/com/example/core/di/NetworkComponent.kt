package com.example.core.di

import com.example.core_network_api.NetworkApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent: NetworkApi {

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }

    companion object {

        @Volatile
        private var networkComponent: NetworkComponent? = null

        fun init(): NetworkComponent {
            if (networkComponent == null) {
                networkComponent = DaggerNetworkComponent
                    .factory()
                    .create()
            }

            return requireNotNull(networkComponent)
        }
    }
}