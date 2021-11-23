package com.composeplayground.tutor.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    //project-level
    object Plugins {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object AndroidUi {
        //android-ui
        const val material = "com.google.android.material:material:${Versions.material}"
        const val androidCoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val lifeCycle = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleKtx}"

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
        const val esspresso = "androidx.test.espresso:espresso-core:${Versions.esspresso}"
        const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    }

    object DebugImplementation {
        //debugImplementation
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
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
    )

    val androidTestLibs = listOf(
        Test.androidxJunit,
        Test.esspresso,
        Test.composeJunit
    )

    val testLibs = listOf(
        Test.junit
    )

    val debugLibs = listOf(
        DebugImplementation.composeUiTooling
    )

}

fun DependencyHandler.addKapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.addImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.addTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.addAndroidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.addDebugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}