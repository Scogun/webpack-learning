import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    kotlin("multiplatform") version "1.9.10"
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            webpackTask(Action {
                mainOutputFileName.set("bundle.[chunkhash].js")
            })
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:1.0.1-pre.634")
                implementation(devNpm("css-loader", "6.8.1"))
                implementation(devNpm("style-loader", "3.3.3"))
                implementation(devNpm("sass-loader", "13.3.2"))
                implementation(devNpm("bootstrap", "5.3.2"))
                implementation(devNpm("@popperjs/core", "2.11.8"))
                implementation(devNpm("node-sass", "8.0.0"))
                implementation(devNpm("html-webpack-plugin", "5.5.3"))
            }
        }
    }
}

tasks.withType<KotlinNpmInstallTask> {
    doLast {
        copy {
            from("node-sass")
            into("${layout.buildDirectory.get()}\\js\\node_modules\\node-sass\\vendor")
        }
    }
}