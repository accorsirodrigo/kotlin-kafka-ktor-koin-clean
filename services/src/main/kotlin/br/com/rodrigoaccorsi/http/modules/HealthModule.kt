package br.com.rodrigoaccorsi.http.modules

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import org.koin.core.annotation.Single

class HealthModule {

    @Single
    fun Application.healthModule() = routing {
        get("/monitor/health") {
            call.respondText("Running!")
        }
    }
}