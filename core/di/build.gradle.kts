plugins {
    id("library-configuration")
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(libs.kotlin.inject.runtime)
    ksp(libs.kotlin.inject.ksp)
}
