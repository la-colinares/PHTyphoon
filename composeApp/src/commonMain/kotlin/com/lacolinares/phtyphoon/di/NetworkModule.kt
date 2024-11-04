package com.lacolinares.phtyphoon.di

import PHTyphoon.composeApp.BuildConfig
import com.lacolinares.phtyphoon.data.remote.PHTyphoonService
import com.lacolinares.phtyphoon.data.remote.RemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal object NetworkModule {
    val dependency = module {
        single {
            HttpClient {
                install(ContentNegotiation) {
                    json(
                        json = Json { ignoreUnknownKeys = true }
                    )
                }
                install(Logging){
                    level = LogLevel.BODY
                }
                install(ResponseObserver) {
                    onResponse { response ->
                        println("HTTP status: ${response.status.value}")
                    }
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = 60000L
                    socketTimeoutMillis = 60000L
                    connectTimeoutMillis = 60000L
                }
                defaultRequest {
                    url(BuildConfig.BASE_URL)
                    header("x-api-key", BuildConfig.X_API_KEY)
                }
            }
        }

        single { PHTyphoonService(get()) }
        single { RemoteDataSource(get()) }
    }
}