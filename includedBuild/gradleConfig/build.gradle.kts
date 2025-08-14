import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
    google()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

kotlin {
    jvmToolchain(11)
}

val libs = the<LibrariesForLibs>()

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradle)

    //kotlin dsl
    implementation(libs.kotlin.stdlib.jdk8)
}

gradlePlugin {
    plugins.register("gradle-configuration") {
        id = "gradle-configuration"
        implementationClass = "com.brsvar.gradleconfig.GradleConfigurationPlugin"
    }
    plugins.register("decompose-configuration") {
        id = "decompose-configuration"
        implementationClass = "com.brsvar.gradleconfig.DecomposeConfigurationPlugin"
    }
    plugins.register("mvi-configuration") {
        id = "mvi-configuration"
        implementationClass = "com.brsvar.gradleconfig.MviKotlinConfigurationPlugin"
    }
    plugins.register("android-library-configuration") {
        id = "android-library-configuration"
        implementationClass = "com.brsvar.gradleconfig.AndroidLibraryModuleConfigurationPlugin"
    }
    plugins.register("library-configuration") {
        id = "library-configuration"
        implementationClass = "com.brsvar.gradleconfig.LibraryModuleConfigurationPlugin"
    }
    plugins.register("compose-configuration") {
        id = "compose-configuration"
        implementationClass = "com.brsvar.gradleconfig.ComposeConfigurationPlugin"
    }
    plugins.register("kotlin-inject-configuration") {
        id = "kotlin-inject-configuration"
        implementationClass = "com.brsvar.gradleconfig.KotlinInjectConfigurationPlugin"
    }
}
