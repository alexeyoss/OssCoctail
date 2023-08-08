package ru.alexeyoss.features.coctails_list.presentation.coctails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.Lazy
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.alexeyoss.core.common.data.Container
import ru.alexeyoss.core.common.di.modules.CoroutinesModule
import ru.alexeyoss.features.coctails_list.domain.usecases.GetCoctailsList
import ru.alexeyoss.features.coctails_list.presentation.coctails.states.CoctailsSideEffects
import ru.alexeyoss.features.coctails_list.presentation.coctails.states.CoctailsUiStates
import javax.inject.Inject

class CoctailsViewModel
@Inject
constructor(
    @CoroutinesModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val getCoctailsList: GetCoctailsList
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable -> }

    private val _coctailsFlow: MutableStateFlow<CoctailsUiStates> = MutableStateFlow(CoctailsUiStates.Initial)
    val coctailsFlow = _coctailsFlow.asStateFlow()

    private val _sideEffects: MutableStateFlow<CoctailsSideEffects> = MutableStateFlow(CoctailsSideEffects.Initial)
    val sideEffects = _sideEffects.asStateFlow()
    fun getCoctailsList() {
        viewModelScope.launch(ioDispatcher + exceptionHandler) {
            getCoctailsList.invoke().collect { container ->
                when (container) {
                    is Container.Error -> {
                        _sideEffects.emit(CoctailsSideEffects.Error(container.exception))
                    }

                    is Container.Loading -> {
                        _coctailsFlow.emit(CoctailsUiStates.Loading)
                    }

                    is Container.Success -> {
                        if (container.value.isEmpty()) {
                            _sideEffects.emit(CoctailsSideEffects.EmptyResult)
                        } else {
                            _sideEffects.emit(CoctailsSideEffects.Success)
                            _coctailsFlow.emit(CoctailsUiStates.Success(container.value))
                        }
                    }
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        @CoroutinesModule.IoDispatcher private val ioDispatcher: Lazy<CoroutineDispatcher>,
        private val getCoctailsList: Lazy<GetCoctailsList>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == CoctailsViewModel::class.java)
            return CoctailsViewModel(
                ioDispatcher.get(),
                getCoctailsList.get()
            ) as T
        }
    }
}

