package com.lacolinares.phtyphoon.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

expect val sharedModule: Module

fun initKoin(config: (KoinApplication.() -> Unit)? = null){
    startKoin {
        config?.invoke(this)
        modules(sharedModule, appModule)
    }
}

private val appModule = module {
    includes(
        NetworkModule.dependency,
        RepositoryModule.dependency,
        ViewModelModule.dependency
    )
}