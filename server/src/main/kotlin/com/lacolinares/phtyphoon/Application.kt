package com.lacolinares.phtyphoon

import com.lacolinares.phtyphoon.di.configureKoin
import com.lacolinares.phtyphoon.plugins.configureAuth
import com.lacolinares.phtyphoon.plugins.configureErrorHandler
import com.lacolinares.phtyphoon.plugins.configureRouting
import com.lacolinares.phtyphoon.plugins.configureSerialization
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.Application
import io.ktor.server.config.HoconApplicationConfig
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.slf4j.LoggerFactory

fun main() {
    embeddedServer(
        factory = Netty,
        environment = applicationEngineEnvironment {
            log = LoggerFactory.getLogger("ktor.application")
            config = HoconApplicationConfig(ConfigFactory.load())
            developmentMode = true
            watchPaths = listOf("class")

            connector {
                port = SERVER_PORT
                host = "0.0.0.0"
            }

            module(Application::module)
        }
    ).start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureKoin()
    configureErrorHandler()
    configureAuth()
    configureRouting()
}