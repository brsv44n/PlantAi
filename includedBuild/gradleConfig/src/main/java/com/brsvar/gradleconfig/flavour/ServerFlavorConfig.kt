package com.brsvar.gradleconfig.flavour

enum class ServerFlavorConfig(
    val flavorName: String,
    val applicationIdSuffix: String?,
    val versionNameSuffix: String?,
    val baseUrl: String,
    val proguardFile: String? = null
) {

    TEST(
        flavorName = "clientTest",
        applicationIdSuffix = ".test",
        versionNameSuffix = "-test",
        baseUrl = "",
    ),
    PRODUCTION(
        flavorName = "clientProduction",
        applicationIdSuffix = null,
        versionNameSuffix = null,
        baseUrl = "",
        proguardFile = null
    )
}
