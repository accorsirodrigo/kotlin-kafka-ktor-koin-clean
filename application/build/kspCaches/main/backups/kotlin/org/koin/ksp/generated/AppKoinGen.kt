package org.koin.ksp.generated
import org.koin.dsl.*

val AppKoinModule = module {
	single(qualifier=null) { br.com.rodrigoaccorsi.components.MakeCoffee() } 
}
val br.com.rodrigoaccorsi.koin.AppKoin.module : org.koin.core.module.Module get() = AppKoinModule