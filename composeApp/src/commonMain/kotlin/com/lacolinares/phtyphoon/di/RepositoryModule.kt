package com.lacolinares.phtyphoon.di

import com.lacolinares.phtyphoon.data.repository.PHTyphoonRepositoryImpl
import com.lacolinares.phtyphoon.domain.repository.PHTyphoonRepository
import org.koin.dsl.module

internal object RepositoryModule {
    val dependency = module {
        single<PHTyphoonRepository> { PHTyphoonRepositoryImpl(get(), get()) }
    }
}