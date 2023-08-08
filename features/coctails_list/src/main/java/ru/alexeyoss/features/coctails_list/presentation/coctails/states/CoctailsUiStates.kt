package ru.alexeyoss.features.coctails_list.presentation.coctails.states

import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail

sealed interface CoctailsUiStates {
    data class Success(val data: List<UiCoctail>) : CoctailsUiStates
    object Loading : CoctailsUiStates
    object Initial : CoctailsUiStates
}