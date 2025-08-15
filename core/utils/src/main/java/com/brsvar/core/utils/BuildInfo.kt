package com.brsvar.core.utils

open class BuildInfo(
    open val platformName: String,
    open val appName: String,
    open val appIcon: Int,
    open val versionName: String,
    open val versionCode: Int,
    open val isDevelopmentBuild: Boolean = true
) {
    val appVersion: String
        get() = versionCode.toString()
}
