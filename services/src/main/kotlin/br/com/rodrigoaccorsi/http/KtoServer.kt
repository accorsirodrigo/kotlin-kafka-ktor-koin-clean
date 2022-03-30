package br.com.rodrigoaccorsi.http

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.metrics.micrometer.MicrometerMetrics
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import jdk.incubator.vector.VectorMask
import org.koin.core.annotation.Single
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.getKoin
import org.koin.java.KoinJavaComponent.inject

@Single
class KtoServer(port: Int = 8000) {

    private val modules: List<Routing> = getKoin().getAll()

    val server = embeddedServer(CIO, port = port, configure = {
        connectionIdleTimeoutSeconds = 45
    }) {
        modules.forEach { routing { it } }
    }

    suspend fun run() = server.start(true)

}