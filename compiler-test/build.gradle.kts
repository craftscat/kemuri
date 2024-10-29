plugins {
    kotlin("jvm")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
    kotlinCompilerPluginClasspath(project(":compiler"))
}
