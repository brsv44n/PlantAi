package com.brsvar.plantai.utils

import com.brsvar.core.utils.BuildInfo

data class AndroidBuildInfo(
    override val appName: String,
    override val appIcon: Int,
    override val versionName: String,
    override val versionCode: Int,
    override val isDevelopmentBuild: Boolean,
    val applicationId: String,
    val fileProviderAuthority: String = "$applicationId.provider"
) : BuildInfo(
    platformName = "Android",
    appName = appName,
    appIcon = appIcon,
    versionName = versionName,
    versionCode = versionCode,
    isDevelopmentBuild = isDevelopmentBuild
)
