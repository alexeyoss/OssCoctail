package ru.alexeyoss.features.coctails_list.presentation.coctails.states

sealed interface CoctailsSideEffects {
    data class Error(val error: Exception) : CoctailsSideEffects
    object EmptyResult : CoctailsSideEffects
    object Success : CoctailsSideEffects
    object Initial : CoctailsSideEffects

}