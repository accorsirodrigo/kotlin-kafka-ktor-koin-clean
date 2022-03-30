package br.com.rodrigoaccorsi.http.modules

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.metrics.micrometer.MicrometerMetrics
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.koin.core.annotation.Single

class MetricsModule {

    @Single
    fun Application.metricsModule(testing: Boolean = false): Routing {
        val appMicrometerRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
        install(MicrometerMetrics) {
            registry = appMicrometerRegistry
            timers { call, _ ->
                tag("region", call.request.headers["regionId"])
            }
        }

        return routing {
            get("/metrics") {
                call.respond(appMicrometerRegistry.scrape())
            }
        }

    }
}