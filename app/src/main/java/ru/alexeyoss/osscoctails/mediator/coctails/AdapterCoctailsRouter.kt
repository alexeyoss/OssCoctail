package ru.alexeyoss.osscoctails.mediator.coctails

import com.github.terrakok.cicerone.Router
import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail
import ru.alexeyoss.features.coctails_list.presentation.CoctailsRouter
import javax.inject.Inject

class AdapterCoctailsRouter
@Inject
constructor(
    private val mainRouter: Router
) : CoctailsRouter {
    override fun launchDetailsScreen(uiCoctail: UiCoctail) {
        TODO()
    }

    override fun goBack() {
        mainRouter.finishChain()
    }
}