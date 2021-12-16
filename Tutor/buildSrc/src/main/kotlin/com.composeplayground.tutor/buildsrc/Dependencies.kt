package com.composeplayground.tutor.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler

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

    object AndroidCore {
        //android-ui
        const val material = "com.google.android.material:material:${Versions.material}"
        const val materialIcon = "com.google.android.material:material-icon:${Versions.material}"
        const val androidCoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
        const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    }

    object JetPackCompose{
        //compose
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        // It provides viewModel() composable and LocalViewModelStoreOwner.
        const val composeUiToolPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val composeLifeCycle ="androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    }

    object AndroidLifeCycle {
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val viewmodelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
        const val viewmodelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
        const val liveDateKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

        //Annotation processor
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
        const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    }

    object Kotlin{
        const val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
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
        AndroidCore.material,
        AndroidCore.androidCoreKtx,
        AndroidCore.appCompat,
        AndroidLifeCycle.runtimeKtx,
        AndroidCore.navigationFragment,
        AndroidCore.navigationKtx,
        JetPackCompose.composeMaterial,
        JetPackCompose.composeUi,
        JetPackCompose.composeUiToolPreview,
        JetPackCompose.composeActivity,
        JetPackCompose.composeLifeCycle,
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

fun DependencyHandler.addAndroidImplementation() {
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