plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinxSerialization)
    application
}

group = "com.lacolinares.phtyphoon"
version = "1.0.4"
application {
    mainClass.set("com.lacolinares.phtyphoon.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

dependencies {
    implementation(libs.logback)
    implementation(libs.bundles.ktor.server)
    implementation(libs.ktor.auth.api.key)
    implementation(libs.koin.di.ktor)
    implementation(libs.koin.di.logger.slf4j)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}