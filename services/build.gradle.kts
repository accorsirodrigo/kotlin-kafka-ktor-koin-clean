
val ktor_version = "1.6.8"
val prometeus_version = "1.7.1"

dependencies  {
    implementation("io.ktor:ktor-metrics-micrometer:$ktor_version")
    implementation("io.micrometer:micrometer-registry-prometheus:$prometeus_version")
}
