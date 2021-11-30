package com.composeplayground.tutor.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.ScriptHandlerScope

object Dependencies {
    //project-level
    object Plugins {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val navigationPlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
        const val hiltPlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    }

    object AndroidUi {
        //android-ui
        const val material = "com.google.android.material:material:${Versions.material}"
        const val androidCoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val lifeCycle = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleKtx}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
        const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"


        //compose
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        const val composeUiToolPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    }

    object Test {
        //test
        const val junit = "junit:junit:${Versions.junit}"
        const val androidxJunit = "androidx.test.ext:junit:${Versions.androidJUnitTest}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.esspresso}"
        const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    }

    object DebugImplementation {
        //debugImplementation
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    }

    object DI {
        const val hiltDependency = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val hiltKaptCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    }

    val appLibs = listOf(
        AndroidUi.material,
        AndroidUi.androidCoreKtx,
        AndroidUi.appCompat,
        AndroidUi.lifeCycle,
        AndroidUi.composeUi,
        AndroidUi.composeMaterial,
        AndroidUi.composeUiToolPreview,
        AndroidUi.composeActivity,
        AndroidUi.navigationFragment,
        AndroidUi.navigationKtx,
        DI.hiltDependency
    )

    val androidTestLibs = listOf(
        Test.androidxJunit,
        Test.espresso,
        Test.composeJunit
    )

    val testLibs = listOf(
        Test.junit
    )

    val debugLibs = listOf(
        DebugImplementation.composeUiTooling
    )

    val kaptProcessors = listOf(
        DI.hiltKaptCompiler
    )
}

fun DependencyHandler.addKapt() {
    Dependencies.kaptProcessors.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.addImplementation() {
    Dependencies.appLibs.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.addTestImplementation() {
    Dependencies.testLibs.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.addAndroidTestImplementation() {
    Dependencies.androidTestLibs.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.addDebugImplementation() {
    Dependencies.debugLibs.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}