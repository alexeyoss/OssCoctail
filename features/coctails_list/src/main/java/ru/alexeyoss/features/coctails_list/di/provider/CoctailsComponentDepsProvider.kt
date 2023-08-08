package ru.alexeyoss.features.coctails_list.di.provider

import ru.alexeyoss.features.coctails_list.di.CoctailsDeps

interface CoctailsComponentDepsProvider {
    fun getCoctailsDeps(): CoctailsDeps
}