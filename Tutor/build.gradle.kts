// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.composeplayground.tutor.buildsrc.Dependencies

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (com.composeplayground.tutor.buildsrc.Dependencies.Plugins.gradle)
        classpath (com.composeplayground.tutor.buildsrc.Dependencies.Plugins.kotlinGradle)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}