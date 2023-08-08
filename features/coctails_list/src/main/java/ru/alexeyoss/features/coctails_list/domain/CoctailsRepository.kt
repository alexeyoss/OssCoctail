package ru.alexeyoss.features.coctails_list.domain

import kotlinx.coroutines.flow.Flow
import ru.alexeyoss.core.common.data.Container
import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail

interface CoctailsRepository {
    suspend fun getCoctailsList(): Flow<Container<List<UiCoctail>>>
}