plugins {
    alias(libs.plugins.kotlin.serialization)
    id("android-library-configuration")
    id("decompose-configuration")
}

android {
    namespace = "com.brsvar.feature.root.api"
}

dependencies {
    implementation(project(":core:decompose"))
}
