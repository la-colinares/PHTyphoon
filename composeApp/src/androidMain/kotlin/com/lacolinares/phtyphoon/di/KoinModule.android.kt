package com.lacolinares.phtyphoon.di

import com.lacolinares.phtyphoon.shared.BrowserClient
import org.koin.core.module.Module
import org.koin.dsl.module

actual val sharedModule: Module = module {
    single { BrowserClient(get()) }
}