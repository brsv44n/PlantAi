package com.brsvar.gradleconfig

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

class AndroidLibraryModuleConfigurationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target.plugins) {
            if (!hasPlugin("com.android.library")) apply("com.android.library")
            if (!hasPlugin("org.jetbrains.kotlin.android")) apply("org.jetbrains.kotlin.android")
        }
        target.extensions.configure(LibraryExtension::class.java) {
            compileSdk = 35

            defaultConfig {
                minSdk = 24
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            target.extensions.configure("java", Action<JavaPluginExtension> {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
                toolchain {
                    languageVersion.set(JavaLanguageVersion.of(11))
                }
            })

            (this as ExtensionAware).extensions.configure(KotlinJvmOptions::class.java) {
                jvmTarget = "11"
            }
        }

        target.dependencies {
            add("testImplementation", target.libs.findLibrary("junit").get())
            add("androidTestImplementation", target.libs.findLibrary("androidx-junit").get())
            add("androidTestImplementation", target.libs.findLibrary("androidx-espresso-core").get())
            add("implementation", target.libs.findLibrary("androidx-core-ktx").get())
        }
    }
}
