package com.lacolinares.phtyphoon.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

fun initKoin(config: (KoinApplication.() -> Unit)? = null){
    startKoin {
        config?.invoke(this)
        modules(platformModule, appModule)
    }
}

private val appModule = module {
    includes(
        DatabaseModule.dependency,
        NetworkModule.dependency,
        RepositoryModule.dependency,
        ViewModelModule.dependency
    )
}