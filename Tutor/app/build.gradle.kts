import com.composeplayground.tutor.buildsrc.*

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.composeplayground.tutor"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.androidTestInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += ("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    addImplementation(Dependencies.appLibs)
    addTestImplementation(Dependencies.testLibs)
    addAndroidTestImplementation(Dependencies.androidTestLibs)
    addDebugImplementation(Dependencies.debugLibs)
}