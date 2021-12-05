import com.composeplayground.tutor.buildsrc.addAndroidImplementation
import com.composeplayground.tutor.buildsrc.addAndroidTestImplementation
import com.composeplayground.tutor.buildsrc.addDebugImplementation
import com.composeplayground.tutor.buildsrc.addKapt

plugins {
    id("dagger.hilt.android.plugin")
}

dependencies {
    addAndroidImplementation()
    addAndroidTestImplementation()
    addDebugImplementation()
    addKapt()
}