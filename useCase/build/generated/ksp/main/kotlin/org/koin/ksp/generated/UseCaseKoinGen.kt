package org.koin.ksp.generated
import org.koin.dsl.*import org.koin.core.qualifier.StringQualifier

val UseCaseKoinModule = module {
	single(qualifier=null) { br.com.rodrigoaccorsi.Job() } bind(br.com.rodrigoaccorsi.Jobble::class)
	single(qualifier=StringQualifier("job2")) { br.com.rodrigoaccorsi.Job2() } bind(br.com.rodrigoaccorsi.Jobble::class)
}
val br.com.rodrigoaccorsi.koin.UseCaseKoin.module : org.koin.core.module.Module get() = UseCaseKoinModule