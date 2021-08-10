import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val uiPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"

        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object Java {
        const val junit = "junit:junit:${Versions.junit}"
    }

    val appLibraries = arrayListOf<String>().apply {
        add(AndroidX.coreKtx)
        add(AndroidX.appCompat)
        add(Google.material)
        add(AndroidX.composeUi)
        add(AndroidX.material)
        add(AndroidX.uiPreview)
        add(AndroidX.lifecycle)
        add(AndroidX.activityCompose)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(Java.junit)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(AndroidX.extJunit)
        add(AndroidX.espressoCore)
        add(AndroidX.composeUiTest)
    }

    val debugLibraries = arrayListOf<String>().apply {
        add(AndroidX.composeUiTooling)
    }
}

// Util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}
