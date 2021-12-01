import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "0.18.0"
}

repositories {
    mavenCentral()
}
