plugins {
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    id("android-library-configuration")
    id("decompose-configuration")
    id("compose-configuration")
}

android {
    namespace = "com.brsvar.feature.onboarding.impl"
}

dependencies {
    implementation(project(":feature:onboarding:api"))

    implementation(project(":core:decompose"))
    implementation(project(":core:di"))
    implementation(project(":compose:ui_kit"))

    implementation(libs.kotlin.inject.runtime)
    ksp(libs.kotlin.inject.ksp)
}
