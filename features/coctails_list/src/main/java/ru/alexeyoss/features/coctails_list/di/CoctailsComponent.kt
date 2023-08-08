package ru.alexeyoss.features.coctails_list.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.alexeyoss.core.common.di.modules.CoroutinesModule
import ru.alexeyoss.core.common.di.scopes.PerScreen
import ru.alexeyoss.features.coctails_list.domain.CoctailsRepository
import ru.alexeyoss.features.coctails_list.presentation.CoctailsRouter
import ru.alexeyoss.features.coctails_list.presentation.coctails.CoctailsListFragment
import ru.alexeyoss.features.coctails_list.presentation.coctails.CoctailsViewModel

@[PerScreen Component(
    modules = [CoctailsModule::class],
    dependencies = [CoctailsDeps::class]
)]
interface CoctailsComponent {
    fun inject(coctailsListFragment: CoctailsListFragment)

    @Component.Builder
    interface Builder {
        fun deps(coctailsDeps: CoctailsDeps): Builder
        fun build(): CoctailsComponent
    }
}


@Module(
    includes = [CoroutinesModule::class]
)
internal interface CoctailsModule {

    @Binds
    @PerScreen
    @[IntoMap ClassKey(CoctailsViewModel::class)]
    fun bindCoctailsViewModel(coctailsViewModel: CoctailsViewModel): ViewModel
}


interface CoctailsDeps {
    val coctailsRouter: CoctailsRouter
    val coctailsRepository: CoctailsRepository
}