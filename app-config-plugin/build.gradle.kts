import org.gradle.kotlin.dsl.`kotlin-dsl`
plugins {
    `kotlin-dsl`
}

dependencies {

    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)

}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}


gradlePlugin{
    plugins.register("loadSecretsPlugin"){
        id = libs.plugins.basshead.loadSecretsPlugin.get().pluginId
        implementationClass = "LoadSecretsPlugin"
    }

    plugins.register("kotlinMultiplatformConventionPlugin") {
        id = libs.plugins.basshead.kotlinMultiplatform.get().pluginId
        implementationClass = "KotlinMultiplatformConventionPlugin"
    }

    plugins.register("androidLibraryConventionPlugin") {
        id = libs.plugins.basshead.androidLibrary.get().pluginId
        implementationClass = "AndroidLibraryConventionPlugin"
    }

    plugins.register("featureModule") {
        id = libs.plugins.basshead.featureModule.get().pluginId
        implementationClass = "FeatureModuleConventionPlugin"
    }

    plugins.register("domainModule") {
        id = libs.plugins.basshead.domainModule.get().pluginId
        implementationClass = "DomainModuleConventionPlugin"
    }

    plugins.register("dataModule") {
        id = libs.plugins.basshead.dataModule.get().pluginId
        implementationClass = "DataModuleConventionPlugin"
    }

}