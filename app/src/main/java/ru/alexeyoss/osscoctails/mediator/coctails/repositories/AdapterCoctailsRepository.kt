package ru.alexeyoss.osscoctails.mediator.coctails.repositories

import android.net.Uri
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexeyoss.core.common.data.Container
import ru.alexeyoss.features.coctails_list.domain.CoctailsRepository
import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail
import ru.alexeyoss.osscoctails.mediator.coctails.mappers.CoctailsMapper
import ru.alexeyoss.services.data.coctails.CoctailsDataRepository
import javax.inject.Inject

class AdapterCoctailsRepository
@Inject
constructor(
    private val coctailsDataRepository: CoctailsDataRepository,
    private val coctailsMapper: CoctailsMapper
) : CoctailsRepository {
    override suspend fun getCoctailsList(): Flow<Container<List<UiCoctail>>> {
        return flow {
            emit(Container.Loading)

            emit(
                Container.Success(
                    listOf(
                        UiCoctail(
                            id = 1,
                            title = "Pink Lemonade",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                        UiCoctail(
                            id = 2,
                            title = "Purple rain",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                        UiCoctail(
                            id = 3,
                            title = "Russia Vodka",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                        UiCoctail(
                            id = 4,
                            title = "Jin",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                        UiCoctail(
                            id = 5,
                            title = "Pink Valter",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                        UiCoctail(
                            id = 6,
                            title = "Yellow Rocket",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                        UiCoctail(
                            id = 7,
                            title = "Brown Day",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                        UiCoctail(
                            id = 8,
                            title = "Red Bull",
                            description = null,
                            recipe = null,
                            photo = Uri.EMPTY
                        ),
                    )
                )
            )

        }
    }

}