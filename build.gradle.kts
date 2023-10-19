plugins {
    kotlin("multiplatform") version "1.9.10"
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        binaries.executable()
        browser()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:1.0.1-pre.634")
                implementation(devNpm("css-loader", "6.8.1"))
                implementation(devNpm("style-loader", "3.3.3"))
            }
        }
    }
}