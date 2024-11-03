package com.lacolinares.phtyphoon.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import com.lacolinares.phtyphoon.domain.usecase.GetDeadliestTyphoonUseCase
import com.lacolinares.phtyphoon.domain.usecase.GetDestructiveTyphoonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeScreenViewModel(
    private val getDeadliestTyphoonUseCase: GetDeadliestTyphoonUseCase,
    private val getDestructiveTyphoonUseCase: GetDestructiveTyphoonUseCase
): ViewModel() {

    private val _deadliestTyphoons = MutableStateFlow<List<DeadliestTyphoon>>(emptyList())
    val deadliestTyphoons = _deadliestTyphoons.asStateFlow()

    private val _destructiveTyphoons = MutableStateFlow<List<DestructiveTyphoon>>(emptyList())
    val destructiveTyphoons = _destructiveTyphoons.asStateFlow()

    init {
        viewModelScope.launch {
            getDeadliestTyphoonUseCase().collectLatest { data ->
                _deadliestTyphoons.update { data }
            }
        }

        viewModelScope.launch {
            getDestructiveTyphoonUseCase().collectLatest { data ->
                _destructiveTyphoons.update { data }
            }
        }
    }
}