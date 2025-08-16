import com.brsvar.gradleconfig.flavour.FlavorConfigurator
import com.brsvar.gradleconfig.flavour.ServerFlavorConfig

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)

    id("decompose-configuration")
    id("mvi-configuration")
    id("kotlin-inject-configuration")
}

android {
    namespace = "com.brsvar.plantai"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.brsvar.plantai"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    flavorDimensions.add("client")
    productFlavors {
        val configurator = FlavorConfigurator(this)
        ServerFlavorConfig.values().forEach { configurator.createFlavor(it) }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //di
    implementation(libs.kotlin.inject.runtime)
    ksp(libs.kotlin.inject.ksp)

    //mvi kotlin
    implementation(libs.mvikotlin.logging)
    implementation(libs.mvikotlin.timetravel)

    implementation(project(":core:di"))
    implementation(project(":core:utils"))
    implementation(project(":core:decompose"))

    implementation(project(":compose:ui_kit"))
    implementation(project(":compose:theme"))

    implementation(project(":feature:root:api"))
    implementation(project(":feature:root:impl"))
    implementation(project(":feature:onboarding:api"))
    implementation(project(":feature:onboarding:impl"))
}