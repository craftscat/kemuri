plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlin.reflect)
    kotlinCompilerPluginClasspath(project(":compiler"))
}
