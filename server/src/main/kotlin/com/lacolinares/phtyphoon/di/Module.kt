package com.lacolinares.phtyphoon.di

import com.lacolinares.phtyphoon.repository.DeadliestTyphoonRepository
import com.lacolinares.phtyphoon.repository.DeadliestTyphoonRepositoryImpl
import com.lacolinares.phtyphoon.repository.DestructiveTyphoonRepository
import com.lacolinares.phtyphoon.repository.DestructiveTyphoonRepositoryImpl
import com.lacolinares.phtyphoon.service.TyphoonService
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

private val appModule = module {
    single<DeadliestTyphoonRepository> { DeadliestTyphoonRepositoryImpl() }
    single<DestructiveTyphoonRepository> { DestructiveTyphoonRepositoryImpl() }
    single { TyphoonService(get(), get()) }
}

fun Application.configureKoin(){
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
}