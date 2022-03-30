package org.koin.ksp.generated
import org.koin.dsl.*

val ServiceKoinModule = module {
	single(qualifier=null) { br.com.rodrigoaccorsi.http.KtoServer(get()) } 
}
val br.com.rodrigoaccorsi.koin.ServiceKoin.module : org.koin.core.module.Module get() = ServiceKoinModule