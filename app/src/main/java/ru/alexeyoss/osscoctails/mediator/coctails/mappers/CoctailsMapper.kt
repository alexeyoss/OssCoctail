package ru.alexeyoss.osscoctails.mediator.coctails.mappers

import ru.alexeyoss.core.common.data.BaseMapper
import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail
import ru.alexeyoss.services.storage.coctails.entitites.CoctailsDTO
import javax.inject.Inject

class CoctailsMapper
@Inject constructor() : BaseMapper<CoctailsDTO, UiCoctail> {
    override fun mapToDomainModel(foreignModel: UiCoctail): CoctailsDTO {
        return CoctailsDTO(
            id = foreignModel.id,
            title = foreignModel.title,
            description = foreignModel.description,
            recipe = foreignModel.recipe,
            photo = foreignModel.photo
        )
    }

    override fun mapToForeignModel(domainModel: CoctailsDTO): UiCoctail {
        return UiCoctail(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            recipe = domainModel.recipe,
            photo = domainModel.photo
        )
    }
}