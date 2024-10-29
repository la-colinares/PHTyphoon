package com.lacolinares.phtyphoon.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import kotlinx.serialization.Serializable
import java.io.FileNotFoundException

@Serializable
private data class ExceptionResponse(
    val code: Int,
    val message: String
)

fun Application.configureErrorHandler() {
    install(StatusPages) {
        exception<Throwable>{ call, cause ->
            when (cause) {
                is FileNotFoundException -> {
                    call.respond(
                        message = ExceptionResponse(
                            code = HttpStatusCode.NotFound.value,
                            message = "The requested JSON file could not be found."
                        )
                    )
                }
            }
        }
        status(HttpStatusCode.Unauthorized, HttpStatusCode.InternalServerError) { call, statusCode ->
            when (statusCode) {
                HttpStatusCode.Unauthorized -> {
                    call.respond(
                        message = ExceptionResponse(
                            code = HttpStatusCode.Unauthorized.value,
                            message = "Access denied. Check your credentials."
                        )
                    )
                }
                HttpStatusCode.InternalServerError -> {
                    call.respond(
                        message = ExceptionResponse(
                            code = HttpStatusCode.InternalServerError.value,
                            message = "An unexpected error occurred. Please try again later."
                        )
                    )
                }
            }
        }
    }
}