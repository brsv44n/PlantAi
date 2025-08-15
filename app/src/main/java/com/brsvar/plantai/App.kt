package com.brsvar.plantai

import android.app.Application
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.timetravel.store.TimeTravelStoreFactory
import com.brsvar.plantai.di.components.AppDiComponent
import com.brsvar.plantai.di.components.DecomposeDiComponent
import com.brsvar.plantai.di.components.create
import com.brsvar.plantai.utils.AndroidBuildInfo

class App : Application() {

    private val buildInfo by lazy {
        AndroidBuildInfo(
            appName = getString(R.string.app_name),
            appIcon = R.mipmap.ic_launcher,
            versionName = BuildConfig.VERSION_NAME,
            versionCode = BuildConfig.VERSION_CODE,
            isDevelopmentBuild = BuildConfig.FLAVOR.contains("production", true),
            applicationId = BuildConfig.APPLICATION_ID
        )
    }

    val appDiComponent by lazy {
        AppDiComponent::class.create(
            application = this,
            storeFactory = LoggingStoreFactory(TimeTravelStoreFactory()),//todo in prod use DefaultStoreFactory()
            buildInfo = buildInfo
        )
    }

    val decomposeDiComponent by lazy {
        DecomposeDiComponent::class.create(appDiComponent)
    }

    override fun onCreate() {
        super.onCreate()
    }
}
