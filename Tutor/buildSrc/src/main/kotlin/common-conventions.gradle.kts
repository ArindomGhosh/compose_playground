import com.composeplayground.tutor.buildsrc.addTestImplementation
import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("android")//org.jetbrains.kotlin.android
    kotlin("kapt")
    id("kotlin-parcelize")
    id("maven-publish")
}

dependencies {
    addTestImplementation()
}