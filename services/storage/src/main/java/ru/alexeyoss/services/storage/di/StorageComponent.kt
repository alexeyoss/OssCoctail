package ru.alexeyoss.services.storage.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.alexeyoss.core.common.di.scopes.PerApplication

interface StorageProvider {}

@[PerApplication Component(
    modules = [StorageModule::class]
)]
interface StorageComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun deps(context: Application): Builder
        fun build(): StorageComponent
    }

}

@Module
internal object StorageModule {

}