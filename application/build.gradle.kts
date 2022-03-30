import com.github.jengelman.gradle.plugins.shadow.transformers.AppendingTransformer

plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":services"))
    implementation(project(":useCase"))
}

application {
    mainClass.set("br.com.rodrigoaccorsi.Application")

    applicationDefaultJvmArgs = listOf(
        "-server",
        "-XX:+UseNUMA",
        "-XX:+UseParallelGC"
    )
}

tasks {
    shadowJar {
        archiveBaseName.set("app")
        archiveVersion.set("")
        archiveClassifier.set("")

        transformers.add(
            AppendingTransformer().apply {
                resource = "reference.conf"
                isZip64 = true
            }
        )
    }
}