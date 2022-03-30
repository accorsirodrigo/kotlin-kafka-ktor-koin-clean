import org.jetbrains.kotlin.ir.backend.js.compile

val javaVersion = findProperty("java.version").toString().toInt()
val koin_version = "3.2.0-beta-1"
val koin_ksp_version = "1.0.0-beta-1"

plugins {
    kotlin("jvm") version "1.6.10"
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"
}

group = "br.com.rodrigoaccorsi"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

allprojects {

    apply {
        plugin("kotlin")
    }

    repositories {
        mavenCentral()
        google()
    }
}

subprojects {

    repositories {
        mavenCentral()
    }

    apply {
        plugin("jacoco")
        plugin("com.google.devtools.ksp")
    }

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

        implementation("io.insert-koin:koin-core:$koin_version")
        implementation("io.insert-koin:koin-annotations:$koin_ksp_version")

        implementation("io.ktor:ktor-server-core:1.6.8")
        implementation("io.ktor:ktor-server-cio:1.6.8")
        implementation("ch.qos.logback:logback-classic:1.2.5")

        ksp("io.insert-koin:koin-ksp-compiler:$koin_ksp_version")

        testImplementation("io.insert-koin:koin-test:$koin_version")
        testImplementation("io.insert-koin:koin-logger-slf4j:$koin_version")
    }

    java.sourceCompatibility = JavaVersion.toVersion(javaVersion)
    java.targetCompatibility = JavaVersion.toVersion(javaVersion)

    group = "br.com.rodrigoaccorsi"
    version = "1.0"



    sourceSets {
        main { java.setSrcDirs(
            listOf(
                "src/main/kotlin",
                "build/generated/ksp/main/kotlin"
            )
        )}
        test { java.setSrcDirs(listOf("src/test/kotlin")) }
    }

    kotlin {
        sourceSets {
            main { kotlin.setSrcDirs(listOf("src/main/kotlin")) }
            test { kotlin.setSrcDirs(listOf("src/test/kotlin")) }
        }
    }
}