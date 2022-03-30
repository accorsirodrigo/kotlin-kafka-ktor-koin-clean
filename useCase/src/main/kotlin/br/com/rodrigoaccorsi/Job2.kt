package br.com.rodrigoaccorsi

import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import org.koin.core.qualifier.named

@Single
@Named("job2")
class Job2 : Jobble {
    override fun runJob() = println("Running job on ${Job2::class.java.simpleName}")
}