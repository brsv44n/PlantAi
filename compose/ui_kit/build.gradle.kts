plugins {
    id("android-library-configuration")
    id("compose-configuration")
}

android {
    namespace = "com.brsvar.compose.ui_kit"
}

dependencies {
    implementation(project(":compose:theme"))
    implementation(project(":core:decompose"))
    implementation(libs.kotlinx.coroutines.core)
}
