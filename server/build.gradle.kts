plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinxSerialization)
    application
}

group = "com.lacolinares.phtyphoon"
version = "1.0.0"
application {
    mainClass.set("com.lacolinares.phtyphoon.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.auth.api.key)
    implementation(libs.koin.di.ktor)
    implementation(libs.koin.di.logger.slf4j)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}