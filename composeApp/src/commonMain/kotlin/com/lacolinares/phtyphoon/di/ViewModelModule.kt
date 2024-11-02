package com.lacolinares.phtyphoon.di

import com.lacolinares.phtyphoon.domain.usecase.GetDeadliestTyphoonUseCase
import com.lacolinares.phtyphoon.domain.usecase.GetTyphoonImageUseCase
import com.lacolinares.phtyphoon.ui.screen.home.HomeScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

internal object ViewModelModule {
    val dependency = module {
        single { GetDeadliestTyphoonUseCase(get()) }
        single { GetTyphoonImageUseCase(get()) }
        viewModel { HomeScreenViewModel(get(), get()) }
    }
}