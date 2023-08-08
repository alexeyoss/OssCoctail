package ru.alexeyoss.services.data.di

import dagger.Component
import ru.alexeyoss.core.common.di.scopes.PerApplication
import ru.alexeyoss.services.data.coctails.CoctailsDataRepository
import ru.alexeyoss.services.data.coctails.di.CoctailsDataModule

interface DataProvider {
    fun getCoctailsDataRepository(): CoctailsDataRepository
}

@[PerApplication Component(
    modules = [
        CoctailsDataModule::class
    ],
    dependencies = [

    ]
)]
interface DataComponent : DataProvider {

    class Initializer private constructor() {
        companion object {

            fun init(): DataProvider {
//                val networkComponent = DaggerNetworkComponent.builder().build()

                return DaggerDataComponent.builder()
//                    .networkProvider(networkComponent)
                    .build()
            }
        }
    }

}