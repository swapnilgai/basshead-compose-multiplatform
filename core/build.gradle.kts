
plugins {
    alias(libs.plugins.basshead.kotlinMultiplatform)
    alias(libs.plugins.basshead.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    sourceSets {

        commonMain.dependencies {
            api(libs.compose.runtime)
            api(libs.compose.foundation)
            api(libs.compose.material3)
            api(libs.compose.ui)
            api(libs.compose.components.resources)
            api(libs.androidx.lifecycle.viewmodelCompose)
        }
    }
}
