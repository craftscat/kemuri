rootProject.name = "kemuri"

pluginManagement {
    repositories {
        mavenCentral()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

include(":compiler", ":compiler-test")
