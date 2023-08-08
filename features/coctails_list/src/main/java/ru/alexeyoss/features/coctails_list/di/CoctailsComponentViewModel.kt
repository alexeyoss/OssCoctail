package ru.alexeyoss.features.coctails_list.di

import androidx.lifecycle.ViewModel

class CoctailsComponentViewModel : ViewModel() {

    fun initCoctailsComponent(coctailsDeps: CoctailsDeps): CoctailsComponent =
        DaggerCoctailsComponent.builder()
            .deps(coctailsDeps)
            .build()
}