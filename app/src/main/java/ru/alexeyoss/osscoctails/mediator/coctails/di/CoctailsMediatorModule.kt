package ru.alexeyoss.osscoctails.mediator.coctails.di

import dagger.Binds
import dagger.Module
import ru.alexeyoss.features.coctails_list.domain.CoctailsRepository
import ru.alexeyoss.features.coctails_list.presentation.CoctailsRouter
import ru.alexeyoss.osscoctails.mediator.coctails.AdapterCoctailsRouter
import ru.alexeyoss.osscoctails.mediator.coctails.repositories.AdapterCoctailsRepository

@Module
interface CoctailsMediatorModule {

    @Binds
    fun bindCoctailsRepository(impl: AdapterCoctailsRepository): CoctailsRepository

    @Binds
    fun bindCoctailsRouter(impl: AdapterCoctailsRouter): CoctailsRouter
}