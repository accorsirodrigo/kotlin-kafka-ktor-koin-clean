package br.com.rodrigoaccorsi

import org.koin.core.annotation.Single

@Single
class Job: Jobble {
    override fun runJob() = println("Running job on ${Job::class.java.simpleName}")
}