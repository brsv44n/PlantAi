package com.brsvar.gradleconfig.flavour

import com.android.build.api.dsl.ApplicationProductFlavor
import org.gradle.api.NamedDomainObjectContainer

class FlavorConfigurator(
    private val container: NamedDomainObjectContainer<ApplicationProductFlavor>
) {

    fun createFlavor(config: ServerFlavorConfig) {
        with(container.create(config.flavorName)) {
            dimension = "client"
            config.applicationIdSuffix?.let { applicationIdSuffix = it }
            config.versionNameSuffix?.let { versionNameSuffix = it }
            buildConfigField("String", "BASE_URL", "\"${config.baseUrl}\"")
            config.proguardFile?.let { proguardFile(it) }
        }
    }
}
