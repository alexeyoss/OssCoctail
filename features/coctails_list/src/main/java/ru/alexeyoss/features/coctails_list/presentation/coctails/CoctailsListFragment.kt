package ru.alexeyoss.features.coctails_list.presentation.coctails

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import dagger.Lazy
import ru.alexeyoss.core_ui.presentation.collectOnLifecycle
import ru.alexeyoss.core_ui.presentation.dp
import ru.alexeyoss.core_ui.presentation.itemDecorators.GridLayoutMarginItemDecoration
import ru.alexeyoss.core_ui.presentation.listeners.BackButtonListener
import ru.alexeyoss.core_ui.presentation.viewBinding.viewBinding
import ru.alexeyoss.features.coctails_list.R
import ru.alexeyoss.features.coctails_list.databinding.FragmentCoctailsListBinding
import ru.alexeyoss.features.coctails_list.di.CoctailsComponentViewModel
import ru.alexeyoss.features.coctails_list.di.provider.CoctailsComponentDepsProvider
import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail
import ru.alexeyoss.features.coctails_list.presentation.CoctailsRouter
import ru.alexeyoss.features.coctails_list.presentation.coctails.states.CoctailsSideEffects
import ru.alexeyoss.features.coctails_list.presentation.coctails.states.CoctailsUiStates
import javax.inject.Inject

class CoctailsListFragment : Fragment(R.layout.fragment_coctails_list),
    BackButtonListener {

    @Inject
    internal lateinit var coctailsViewModelFactory: Lazy<CoctailsViewModel.Factory>
    private val viewModel by viewModels<CoctailsViewModel> {
        coctailsViewModelFactory.get()
    }

    @Inject
    internal lateinit var coctailsRouter: CoctailsRouter

    private val binding by viewBinding<FragmentCoctailsListBinding>()
    private val coctailsAdapter = CoctailsAdapter(::onCoctailClick)

    override fun onAttach(context: Context) {
        val coctailsDeps = (context.applicationContext as CoctailsComponentDepsProvider).getCoctailsDeps()

        ViewModelProvider(this@CoctailsListFragment).get<CoctailsComponentViewModel>()
            .initCoctailsComponent(coctailsDeps)
            .inject(this@CoctailsListFragment)

        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        initListeners()

        viewModel.getCoctailsList()
    }

    private fun initListeners() {
        viewModel.coctailsFlow.collectOnLifecycle(this@CoctailsListFragment) { uiState ->
            when (uiState) {
                is CoctailsUiStates.Initial -> Unit
                is CoctailsUiStates.Loading -> Unit
                is CoctailsUiStates.Success -> {
                    coctailsAdapter.submitList(uiState.data)
                }
            }
        }


        viewModel.sideEffects.collectOnLifecycle(this@CoctailsListFragment) { sideEffects ->
            when (sideEffects) {
                is CoctailsSideEffects.EmptyResult -> {
                    setEmptyViewState()
                }

                is CoctailsSideEffects.Success -> {
                    setResultState()
                }

                is CoctailsSideEffects.Error -> Unit
                is CoctailsSideEffects.Initial -> Unit
            }
        }
    }

    private fun setResultState() = with(binding) {
        recyclerView.visibility = View.VISIBLE
        emptyListPlaceHolder.visibility = View.GONE
        hintTextBellowFab.hintTextLayoutCoctail.visibility = View.GONE
    }

    private fun setEmptyViewState() = with(binding) {
        recyclerView.visibility = View.GONE
        emptyListPlaceHolder.visibility = View.VISIBLE
        hintTextBellowFab.hintTextLayoutCoctail.visibility = View.VISIBLE

    }

    private fun initRecyclerView() = with(binding) {
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, GRID_SPAN_COUNT, GridLayoutManager.VERTICAL, false)
            adapter = coctailsAdapter

            addItemDecoration(
                GridLayoutMarginItemDecoration(
                    spanCount = GRID_SPAN_COUNT, spacing = GRID_SPACING.dp, includeEdge = false
                )
            )
            itemAnimator = null
        }
    }

    private fun onCoctailClick(uiCoctail: UiCoctail) {
        coctailsRouter.launchDetailsScreen(uiCoctail)
    }


    companion object {
        fun getNewInstance(): CoctailsListFragment {
            return CoctailsListFragment()
        }

        private const val GRID_SPAN_COUNT = 2
        private const val GRID_SPACING = 8
    }

    override fun onBackPressed(): Boolean {
        coctailsRouter.goBack()
        return true
    }
}