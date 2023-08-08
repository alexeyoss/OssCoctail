package ru.alexeyoss.osscoctails

import dagger.Component
import ru.alexeyoss.core.common.di.scopes.PerApplication
import ru.alexeyoss.features.coctails_list.di.CoctailsDeps
import ru.alexeyoss.osscoctails.activity.MainActivity
import ru.alexeyoss.osscoctails.mediator.coctails.di.CoctailsMediatorModule
import ru.alexeyoss.osscoctails.navigation.di.NavigationModule
import ru.alexeyoss.services.data.di.DataComponent
import ru.alexeyoss.services.data.di.DataProvider


interface AppComponentProvider :
    DataProvider,
    CoctailsDeps

@[PerApplication Component(
    modules = [
        CoctailsMediatorModule::class,
        NavigationModule::class
    ],
    dependencies = [
        DataProvider::class
    ]
)]

interface AppComponent : AppComponentProvider {

    fun inject(app: OssCoctailsApp)

    fun inject(mainActivity: MainActivity)

    class Initializer private constructor() {
        companion object {

            val dataProvider = DataComponent.Initializer.init()

            fun init(): AppComponent {
                return DaggerAppComponent.builder()
                    .dataProvider(dataProvider)
                    .build()
            }
        }
    }
}