package org.basshead.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow

abstract class BaseViewModel<UiState, UiEvent>(initialState: UiState): ViewModel() {

    val _state = MutableStateFlow<UiState>(initialState)
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<UiEvent>(replay = 0)


    init {
        viewModelScope.launch {
            _event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun handleEvent(uiEvent: UiEvent)

}