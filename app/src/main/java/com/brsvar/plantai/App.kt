package com.brsvar.plantai

import android.app.Application
import com.brsvar.plantai.di.components.AppDiComponent
import com.brsvar.plantai.di.components.create

class App : Application() {

    val appDiComponent by lazy {
        AppDiComponent::class.create(
            application = this
        )
    }

    override fun onCreate() {
        super.onCreate()
    }
}
