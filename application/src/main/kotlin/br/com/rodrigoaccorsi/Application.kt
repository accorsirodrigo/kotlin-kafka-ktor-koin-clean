package br.com.rodrigoaccorsi

import br.com.rodrigoaccorsi.http.KtoServer
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.ksp.generated.AppKoinModule
import org.koin.ksp.generated.ServiceKoinModule
import org.koin.ksp.generated.UseCaseKoinModule

class Application : KoinComponent {

    private val ktor: KtoServer by inject { parametersOf(8001) }

    suspend fun run() {
        ktor.run()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            startKoin {
                modules(
                    listOf(
                        AppKoinModule,
                        UseCaseKoinModule,
                        ServiceKoinModule
                    )
                )
            }
            Application().run()
        }
    }

}