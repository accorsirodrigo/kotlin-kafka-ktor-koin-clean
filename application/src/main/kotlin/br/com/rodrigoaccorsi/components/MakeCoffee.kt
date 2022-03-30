package br.com.rodrigoaccorsi.components

import org.koin.core.annotation.Single

@Single
class MakeCoffee {

    fun brew() {
        println("Making coffee")
    }

}