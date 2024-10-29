package com.lacolinares.phtyphoon.plugins

import dev.forst.ktor.apikey.apiKey
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.Principal

// principal for the app
private data class AppPrincipal(val key: String) : Principal

fun Application.configureAuth(){
    val xApiKey = environment.config.propertyOrNull("ktor.x_api_key")?.getString() ?: "None"

    install(Authentication){
        apiKey {
            validate { keyFromHeader ->
                keyFromHeader.takeIf { it == xApiKey }?.let { AppPrincipal(it) }
            }
        }
    }
}