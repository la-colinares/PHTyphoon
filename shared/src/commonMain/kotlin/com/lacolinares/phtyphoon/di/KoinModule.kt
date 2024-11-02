package com.lacolinares.phtyphoon.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

expect val targetModule: Module

fun initKoin(
    config: (KoinApplication.() -> Unit)? = null
){
    startKoin {
        config?.invoke(this)
        modules(targetModule)
    }
}