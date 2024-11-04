package com.lacolinares.phtyphoon.di

import com.lacolinares.phtyphoon.data.local.PHTyphoonDatabase
import com.lacolinares.phtyphoon.db.getDatabaseBuilder
import com.lacolinares.phtyphoon.shared.BrowserClient
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { BrowserClient() }
    single<PHTyphoonDatabase> { getDatabaseBuilder() }
}