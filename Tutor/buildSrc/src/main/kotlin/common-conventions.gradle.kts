import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("android")//org.jetbrains.kotlin.android
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}