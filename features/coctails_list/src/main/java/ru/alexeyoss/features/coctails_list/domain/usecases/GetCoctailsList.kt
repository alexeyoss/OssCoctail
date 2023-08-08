package ru.alexeyoss.features.coctails_list.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.alexeyoss.core.common.data.Container
import ru.alexeyoss.features.coctails_list.domain.CoctailsRepository
import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail
import javax.inject.Inject

class GetCoctailsList
@Inject
constructor(
    private val coctailsRepository: CoctailsRepository
) {

    suspend operator fun invoke(): Flow<Container<List<UiCoctail>>> {
        return coctailsRepository.getCoctailsList()
    }
}