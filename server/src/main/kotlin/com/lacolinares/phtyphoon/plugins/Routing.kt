package com.lacolinares.phtyphoon.plugins

import com.lacolinares.phtyphoon.service.TyphoonService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.http.content.staticResources
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val service by inject<TyphoonService>()

    routing {
        authenticate {
            staticResources("/resources", "images")
        }

        get("/") {
            call.respondText("Server is up!")
        }

        authenticate {
            route("/typhoon") {
                get("/deadliest") {
                    val deadliestTyphoons = service.getDeadliestTyphoons()
                    call.respond(deadliestTyphoons)
                }

                get("/destructive") {
                    val deadliestTyphoons = service.getDestructiveTyphoons()
                    call.respond(deadliestTyphoons)
                }
            }
        }
    }
}