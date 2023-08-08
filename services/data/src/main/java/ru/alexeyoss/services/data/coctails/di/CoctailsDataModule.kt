package ru.alexeyoss.services.data.coctails.di

import dagger.Binds
import dagger.Module
import ru.alexeyoss.core.common.di.scopes.PerApplication
import ru.alexeyoss.services.data.coctails.CoctailsDataRepository
import ru.alexeyoss.services.data.coctails.CoctailsDataRepositoryImpl
import ru.alexeyoss.services.data.coctails.sources.CoctailsDataSource
import ru.alexeyoss.services.data.coctails.sources.CoctailsDataSourceImpl

@Module
internal interface CoctailsDataModule {
    @Binds
    @PerApplication
    fun bindCoctailsDataRepository(impl: CoctailsDataRepositoryImpl): CoctailsDataRepository

    @Binds
    @PerApplication
    fun bindCoctailsDataSource(impl: CoctailsDataSourceImpl): CoctailsDataSource
}