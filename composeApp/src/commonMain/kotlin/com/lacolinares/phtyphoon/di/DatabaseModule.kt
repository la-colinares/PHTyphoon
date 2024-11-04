package com.lacolinares.phtyphoon.di

import com.lacolinares.phtyphoon.data.local.LocalDataSource
import com.lacolinares.phtyphoon.data.local.PHTyphoonDatabase
import org.koin.dsl.module

object DatabaseModule {

    val dependency = module {
        single { get<PHTyphoonDatabase>().typhoonDao() }
        single { LocalDataSource(get()) }
    }

}