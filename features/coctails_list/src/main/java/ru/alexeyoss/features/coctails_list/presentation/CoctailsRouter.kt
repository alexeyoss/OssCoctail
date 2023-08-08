package ru.alexeyoss.features.coctails_list.presentation

import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail

interface CoctailsRouter {

    /**
     * Go to details screen feature
     * */
    fun launchDetailsScreen(uiCoctail: UiCoctail)

    /**
     * Go back to the previous screen.
     */
    fun goBack()

}