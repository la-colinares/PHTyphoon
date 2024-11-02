package com.lacolinares.phtyphoon.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.usecase.GetDeadliestTyphoonUseCase
import com.lacolinares.phtyphoon.domain.usecase.GetTyphoonImageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getDeadliestTyphoonUseCase: GetDeadliestTyphoonUseCase,
    private val getTyphoonImageUseCase: GetTyphoonImageUseCase,
): ViewModel() {

    private val _deadliestTyphoons = MutableStateFlow<List<DeadliestTyphoon>>(emptyList())
    val deadliestTyphoons = _deadliestTyphoons.asStateFlow()

    init {
        viewModelScope.launch {
            getDeadliestTyphoonUseCase().collectLatest { data ->
                _deadliestTyphoons.update { data }
            }
        }
    }

    suspend fun loadImage(imageName: String, type: String): String {
        return getTyphoonImageUseCase.invoke(imageName, type)
    }
}